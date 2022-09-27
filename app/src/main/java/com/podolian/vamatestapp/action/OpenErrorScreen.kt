package com.podolian.vamatestapp.action

import androidx.navigation.NavController
import com.podolian.vamatestapp.action.contract.Action

class OpenErrorScreen(val data: HashMap<*, *>) : Action {
    override suspend fun invoke(navController: NavController) {}
}