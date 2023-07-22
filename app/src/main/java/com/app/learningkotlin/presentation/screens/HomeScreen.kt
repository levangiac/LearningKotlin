package com.app.learningkotlin.presentation.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.learningkotlin.presentation.BottomBarScreen
import com.app.learningkotlin.presentation.Screen
import com.app.learningkotlin.presentation.coin_detail.CoinDetailScreen
import com.app.learningkotlin.presentation.navigation.HomeNavGraph
import com.app.learningkotlin.presentation.ui.theme.ColorBackgroundLauncher

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        BottomBarScreen.CoinListScreen,
        BottomBarScreen.Tab1,
        BottomBarScreen.Tab2,
        BottomBarScreen.Tab3,
        )
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
//    if (bottomBarDestination) {
//        BottomNavigation(
//            contentColor = Color.White,
//            backgroundColor = ColorBackgroundLauncher,) {
//            screens.forEach { screen ->
//                AddItem(
//                    screen = screen,
//                    currentDestination = currentDestination,
//                    navController = navController,
//                )
//            }
//        }
//    }
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.route, modifier = Modifier.padding(top = 30.dp)) },
                label = { Text(text = item.route, color = if(selected) Color.White else Color.White.copy(0.4f) ) },
                selectedContentColor = Color.White,
//                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

//@Composable
//fun RowScope.AddItem(
//    screen: BottomBarScreen,
//    currentDestination: NavDestination?,
//    navController: NavHostController,
//) {
//    BottomNavigationItem(
//        modifier = Modifier.padding(top = 15.dp ).align(CenterVertically),
//        label = {
//            Text(text = screen.route,
//                 style = MaterialTheme.typography.body2,
//            )
//        },
//        icon = {
//            Icon(
//                painterResource(id = screen.icon ),
//                contentDescription = screen.route
//            )
//        },
//        alwaysShowLabel = true,
//        selectedContentColor = Color.White,
//        unselectedContentColor =Color.White.copy(0.4f),
//        selected = currentDestination?.hierarchy?.any {
//            it.route == screen.route
//        } == true,
//        onClick = {
//            navController.navigate(screen.route) {
//                // Pop up to the start destination of the graph to
//                // avoid building up a large stack of destinations
//                // on the back stack as users select items
//                 popUpTo(navController.graph.findStartDestination().id)
////                navController.graph.startDestinationRoute?.let { route ->
////                    popUpTo(route) {
////                        saveState = true
////                    }
////                }
//                launchSingleTop = true
//
//            }
//        }
//    )
//}