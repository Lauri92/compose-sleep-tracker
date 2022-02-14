package fi.lauriari.sleep_tracker.ui.screens.list

import androidx.compose.foundation.Image
import fi.lauriari.sleep_tracker.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.components.DeleteAlertDialog
import fi.lauriari.sleep_tracker.models.SleepRecord
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import java.text.DateFormat


@Composable
fun ListContent(
    allSleepRecords: List<SleepRecord>,
    navigateToSleepRecordScreen: (Int) -> Unit,
    deleteSleepRecord: () -> Unit,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(
                items = allSleepRecords,
                key = { sleepRecord ->
                    sleepRecord.id
                }
            ) { sleepRecord ->
                SleepRecordListItem(
                    mainViewModel = mainViewModel,
                    sleepRecord = sleepRecord,
                    navigateToSleepRecordScreen = navigateToSleepRecordScreen,
                    deleteSleepRecord = deleteSleepRecord
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SleepRecordListItem(
    sleepRecord: SleepRecord,
    navigateToSleepRecordScreen: (Int) -> Unit,
    deleteSleepRecord: () -> Unit,
    mainViewModel: MainViewModel
) {

    val context = LocalContext.current

    var openDialog by remember { mutableStateOf(false) }

    DeleteAlertDialog(
        title = formatMillisecondsToDate(sleepRecord.sleepDate),
        message = "Delete sleep recording from ${formatMillisecondsToDate(sleepRecord.sleepDate)}?",
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = deleteSleepRecord

    )

    val image: Int = when (sleepRecord.sleepQuality) {
        "Poor" -> {
            R.drawable.ic_sleep_1
        }
        "Fair" -> {
            R.drawable.ic_sleep_2
        }
        "Average" -> {
            R.drawable.ic_sleep_3
        }
        "Good" -> {
            R.drawable.ic_sleep_4
        }
        "Very Good" -> {
            R.drawable.ic_sleep_5
        }
        else -> {
            R.drawable.ic_sleep_0
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Green,
                shape = RectangleShape
            ),
        color = Color.Gray,
        shape = RectangleShape,
        elevation = 3.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(all = 5.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(8F)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Date recorded: ${formatMillisecondsToDate(sleepRecord.sleepDate)}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Text(text = "Time slept: ${sleepRecord.sleepHours} Hours and ${sleepRecord.sleepMinutes} Minutes")
                    Text(text = "Sleep quality: ${sleepRecord.sleepQuality}")
                    Row(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        IconButton(
                            onClick = {
                                mainViewModel.updateSleepRecordInputs(sleepRecord)
                                openDialog = true
                            }
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.Red
                            )
                        }
                        IconButton(
                            onClick = {
                                navigateToSleepRecordScreen(sleepRecord.id)
                            }
                        ) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "Delete",
                                tint = Color.Blue
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(2F),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 15.dp, top = 20.dp, end = 15.dp)
                    )
                }
            }
        }
    }
}

private fun formatMillisecondsToDate(milliseconds: Long): String {
    return DateFormat.getDateInstance().format(milliseconds)
}





