package com.example.listofgoods.domain.usecase

import com.example.listofgoods.domain.repository.GoodsRepository

class GetGoodsListUseCase(private val repository: GoodsRepository) {
    fun execute(query: String) = repository.getGoodsList(
        query = query
    )
}