package com.app.learningkotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.learningkotlin.presentation.Screen
import com.app.learningkotlin.presentation.coin_detail.CoinDetailScreen
import com.app.learningkotlin.presentation.screens.HomeScreen
import com.app.learningkotlin.presentation.screens.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(navController = navController, route = Graph.ROOT, startDestination = Screen.SplashScreen.router ){
        composable(
             route = Screen.SplashScreen.router
            ){
            SplashScreen(navController)
        }
        composable(route = Graph.APPBOTTOMTAB) {
            HomeScreen()
        }

    }
}
object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val APPBOTTOMTAB = "app_bottom_tab"
}