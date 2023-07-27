package com.app.learningkotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.app.learningkotlin.presentation.BottomBarScreen
import com.app.learningkotlin.presentation.Screen
import com.app.learningkotlin.presentation.coin_detail.CoinDetailScreen
import com.app.learningkotlin.presentation.coin_list.CoinListScreen
import com.app.learningkotlin.presentation.screens.ScreenContent


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.APPBOTTOMTAB,
        startDestination = BottomBarScreen.CoinListScreen.route
    ) {
        composable(route = BottomBarScreen.CoinListScreen.route) {
            CoinListScreen(navController)
        }
        composable(route = BottomBarScreen.Tab1.route) {
            ScreenContent(
                name = BottomBarScreen.Tab1.route,
                onClick = { }
            )
        }
        composable(route = BottomBarScreen.Tab2.route) {
            ScreenContent(
                name = BottomBarScreen.Tab2.route,
                onClick = { }
            )
        }
        composable(route = BottomBarScreen.Tab3.route) {
            ScreenContent(
                name = BottomBarScreen.Tab3.route,
                onClick = { }
            )
        }
        detailsNavGraph(navController = navController)
    }
}


fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route =Graph.ROOT,
        startDestination = Screen.CoinDetailScreen.router
    ) {
        composable(route = Screen.CoinDetailScreen.router + "/{coinId}") {
            CoinDetailScreen(navController) }
    }
}

