package fi.lauriari.sleep_tracker.navigation

import androidx.navigation.NavHostController

class Screens(navController: NavHostController) {

    val list: () -> Unit = {
        navController.navigate(route = "list")
    }

    val sleepRecord: (Int) -> Unit = { sleepRecordId ->
        navController.navigate(route = "sleeprecord/$sleepRecordId")
    }

}