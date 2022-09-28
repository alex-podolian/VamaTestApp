package com.podolian.vamatestapp.action

import androidx.navigation.NavController
import com.podolian.vamatestapp.action.contract.Action
import com.podolian.domain.model.Result

class OpenAlbumDetailsScreen(var result: Result) : Action {
    override suspend fun invoke(navController: NavController) {}
}