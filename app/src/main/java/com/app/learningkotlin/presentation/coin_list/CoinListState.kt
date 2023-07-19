package com.app.learningkotlin.presentation.coin_list

import com.app.learningkotlin.domain.model.Coin


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String =""
)
