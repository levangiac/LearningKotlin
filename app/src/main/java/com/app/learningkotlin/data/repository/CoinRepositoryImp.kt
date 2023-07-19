package com.app.learningkotlin.data.repository

import com.app.learningkotlin.data.remote.CoinPaprikaApi
import com.app.learningkotlin.data.remote.dto.CoinDetailDto
import com.app.learningkotlin.data.remote.dto.CoinDto
import com.app.learningkotlin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api:CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoin()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
      return api.getCoinById(coinId)
    }
}