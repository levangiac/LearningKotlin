package com.app.learningkotlin.domain.use_case.get_coins

import com.app.learningkotlin.common.Resource
import com.app.learningkotlin.data.remote.dto.toCoin

import com.app.learningkotlin.domain.repository.CoinRepository
import com.app.learningkotlin.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
 operator fun invoke():Flow<Resource<List<Coin>>> = flow{
    try {
        emit(Resource.Loading())
         val coins = repository.getCoins().map { it.toCoin() }
        emit(Resource.Success(coins))
    }catch (e: HttpException){
        emit(Resource.Error(e.localizedMessage?: "Error"))
    }
}
}