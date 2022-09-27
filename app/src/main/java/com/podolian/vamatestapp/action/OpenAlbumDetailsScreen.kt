package com.podolian.vamatestapp.action

import androidx.navigation.NavController
import com.podolian.domain.model.Feed
import com.podolian.vamatestapp.action.contract.Action

class OpenAlbumDetailsScreen(var feed: Feed) : Action {
    override suspend fun invoke(navController: NavController) {}
}