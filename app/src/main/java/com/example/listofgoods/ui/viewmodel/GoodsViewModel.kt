package com.example.listofgoods.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofgoods.domain.usecase.DeleteGoodsUseCase
import com.example.listofgoods.domain.usecase.EditGoodsUseCase
import com.example.listofgoods.domain.usecase.GetGoodsListUseCase
import com.example.listofgoods.ui.model.GoodsModel
import com.example.listofgoods.ui.utils.asDomain
import com.example.listofgoods.ui.utils.asUi
import com.example.listofgoods.ui.utils.logError
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GoodsViewModel(
    private val getGoodsListUseCase: GetGoodsListUseCase,
    private val deleteGoodsUseCase: DeleteGoodsUseCase,
    private val editGoodsUseCase: EditGoodsUseCase
) : ViewModel() {
    private val _goodsList = MutableStateFlow<List<GoodsModel>>(
        value = listOf()
    )
    val goodsList = _goodsList.asStateFlow()

    private val coroutineExceptionHandler get() = CoroutineExceptionHandler { _, throwable ->
        logError(throwable = throwable)
    }

    fun getGoodsList(query: String) {
        viewModelScope.launch(context = coroutineExceptionHandler + Dispatchers.IO) {
            getGoodsListUseCase.execute(query = query).collect { goods ->
                _goodsList.value = goods.asUi
            }
        }
    }

    fun deleteGoods(id: Int) {
        viewModelScope.launch(context = coroutineExceptionHandler + Dispatchers.Main) {
            deleteGoodsUseCase.execute(id = id)
        }
    }

    fun editGoods(goods: GoodsModel) {
        viewModelScope.launch(context = coroutineExceptionHandler + Dispatchers.IO) {
            editGoodsUseCase.execute(goods = goods.asDomain)
        }
    }
}