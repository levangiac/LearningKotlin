package com.app.learningkotlin.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.learningkotlin.R

sealed class Screen (val router:String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
    object  SplashScreen:Screen("splash_screen")
}
sealed class BottomBarScreen(val route: String,@DrawableRes val icon: Int,val title: Int) {
    object CoinListScreen : BottomBarScreen("Home", R.drawable.home,R.string.Home)
    object Tab1 : BottomBarScreen("Tab1",  R.drawable.event, R.string.Tab1)
    object Tab2 : BottomBarScreen("Tab2", R.drawable.document,R.string.Tab2)
    object Tab3 : BottomBarScreen("Tab3",  R.drawable.user,R.string.Tab3)
}
