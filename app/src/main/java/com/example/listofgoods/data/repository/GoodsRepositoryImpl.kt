package com.example.listofgoods.data.repository

import com.example.listofgoods.data.dao.GoodsDao
import com.example.listofgoods.data.utils.asData
import com.example.listofgoods.data.utils.asDomain
import com.example.listofgoods.domain.model.Goods
import com.example.listofgoods.domain.repository.GoodsRepository
import kotlinx.coroutines.flow.map

class GoodsRepositoryImpl(private val goodsDao: GoodsDao) : GoodsRepository {
    override fun getGoodsList(query: String) = goodsDao.getGoodsList(
        query = "%${query}%"
    ).map { goods ->
        goods.asDomain
    }

    override suspend fun deleteGoods(id: Int) {
        goodsDao.deleteGoods(id = id)
    }

    override suspend fun editGoods(goods: Goods) {
        goodsDao.editGoods(goods = goods.asData)
    }
}