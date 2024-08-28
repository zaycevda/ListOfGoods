package com.example.listofgoods.ui.utils

import com.example.listofgoods.domain.model.Goods
import com.example.listofgoods.ui.model.GoodsModel

val List<Goods>.asUi get() = map { goods ->
    goods.asUi
}

val Goods.asUi get() = GoodsModel(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount
)

val GoodsModel.asDomain get() = Goods(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount
)