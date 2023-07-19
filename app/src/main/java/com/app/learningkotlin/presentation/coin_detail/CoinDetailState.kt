package com.app.learningkotlin.presentation.coin_detail

import com.app.learningkotlin.domain.model.Coin
import com.app.learningkotlin.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin:CoinDetail ?= null,
    val error: String =""
)
