package com.app.learningkotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable(route = Screen.CoinDetailScreen.router + "/{coinId}") { CoinDetailScreen() }
//        detailsNavGraph(navController = navController)
    }
}

//fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.DETAILS,
//        startDestination = DetailsScreen.Information.route
//    ) {
//        composable(route = DetailsScreen.Information.route) {
//            ScreenContent(name = DetailsScreen.Information.route) {
//                navController.navigate(DetailsScreen.Overview.route)
//            }
//        }
//        composable(route = DetailsScreen.Overview.route) {
//            ScreenContent(name = DetailsScreen.Overview.route) {
//                navController.popBackStack(
//                    route = DetailsScreen.Information.route,
//                    inclusive = false
//                )
//            }
//        }
//    }
//}

//sealed class DetailsScreen(val route: String) {
//    object Information : DetailsScreen(route = "INFORMATION")
//    object Overview : DetailsScreen(route = "OVERVIEW")
//}