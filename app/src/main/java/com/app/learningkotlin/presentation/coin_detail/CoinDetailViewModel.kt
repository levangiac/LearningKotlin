package com.app.learningkotlin.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.learningkotlin.common.Constants
import com.app.learningkotlin.common.Resource
import com.app.learningkotlin.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase :GetCoinUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private  val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state
    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN)?.let { coinId ->   getCoin(coinId)}

    }
    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach {
            resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value = CoinDetailState(coin = resource.data )
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = resource.message ?:"Error")

                }
            }
        }.launchIn(viewModelScope)

    }
}