package com.app.learningkotlin.presentation

sealed class Screen (val router:String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}
