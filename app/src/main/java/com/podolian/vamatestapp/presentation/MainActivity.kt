package com.podolian.vamatestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.podolian.domain.model.ItemData
import com.podolian.vamatestapp.action.OpenAlbumDetailsScreen
import com.podolian.vamatestapp.action.OpenErrorScreen
import com.podolian.vamatestapp.action.contract.ActionExecutor
import com.podolian.vamatestapp.presentation.albumdetails.AlbumDetailsScreen
import com.podolian.vamatestapp.ui.theme.VamaTestAppTheme
import com.podolian.vamatestapp.presentation.albums.AlbumsScreen

private const val NAV_ROUTE_ALBUM_DETAILS_SCREEN = "AlbumDetailsScreen"
private const val NAV_ROUTE_ALBUMS_SCREEN = "AlbumsScreen"
private const val NAV_ROUTE_ERROR_SCREEN = "ErrorScreen"

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            VamaTestAppTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = true
                    )
                    systemUiController.isNavigationBarVisible = false
                }

                navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                val actionExecutor: ActionExecutor = { action ->
                    when (action) {
                        is OpenAlbumDetailsScreen -> {
                            val bundle = Bundle()
                            bundle.putSerializable("data", action.data)
                            bundle.putString("copyright", action.copyright)
                            val resId =
                                navController.findDestination(NAV_ROUTE_ALBUM_DETAILS_SCREEN)?.id
                            resId?.let { navController.navigate(it, bundle) }
                        }
                        is OpenErrorScreen -> {
                            //TODO: add handling
                        }
                    }
                }

                Scaffold(
                    scaffoldState = scaffoldState,
                    backgroundColor = Color.Transparent
                ) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = NAV_ROUTE_ALBUMS_SCREEN
                        ) {
                            composable(NAV_ROUTE_ALBUMS_SCREEN) {
                                AlbumsScreen(actionExecutor)
                            }
                            composable(NAV_ROUTE_ALBUM_DETAILS_SCREEN) { backStackEntry ->
                                val data = backStackEntry.arguments?.getSerializable("data")!!
                                val copyright = backStackEntry.arguments?.getString("copyright")!!
                                AlbumDetailsScreen(data as ItemData, copyright, navController)
                            }
                            composable(NAV_ROUTE_ERROR_SCREEN) { backStackEntry ->
                                //TODO: add handling
                            }
                        }
                    }
                }

            }
        }
    }
}