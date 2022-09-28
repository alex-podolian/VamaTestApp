package com.podolian.vamatestapp.action

import androidx.navigation.NavController
import com.podolian.vamatestapp.action.contract.Action
import com.podolian.domain.model.ItemData

class OpenAlbumDetailsScreen(var data: ItemData, var copyright: String) : Action {
    override suspend fun invoke(navController: NavController) {}
}