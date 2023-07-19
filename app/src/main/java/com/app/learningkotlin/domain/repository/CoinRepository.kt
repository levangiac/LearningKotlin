package com.app.learningkotlin.domain.repository

import com.app.learningkotlin.data.remote.dto.CoinDetailDto
import com.app.learningkotlin.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}