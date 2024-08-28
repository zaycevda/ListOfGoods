package com.example.listofgoods.data.utils

import com.example.listofgoods.data.model.GoodsEntity
import com.example.listofgoods.domain.model.Goods

val List<GoodsEntity>.asDomain
    get() = map { goods ->
        goods.asDomain
    }

val GoodsEntity.asDomain
    get() = Goods(
        id = id,
        name = name,
        time = time,
        tags = tags,
        amount = amount
    )

val Goods.asData
    get() = GoodsEntity(
        id = id,
        name = name,
        time = time,
        tags = tags,
        amount = amount
    )