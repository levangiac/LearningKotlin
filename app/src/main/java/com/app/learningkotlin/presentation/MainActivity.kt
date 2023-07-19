package com.app.learningkotlin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.learningkotlin.presentation.coin_detail.CoinDetailScreen
import com.app.learningkotlin.presentation.coin_list.CoinListScreen
import com.app.learningkotlin.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                        val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.router ){
                        composable(
                            route = Screen.CoinListScreen.router
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.router + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}