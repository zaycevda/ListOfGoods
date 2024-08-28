package com.example.listofgoods.domain.model

data class Goods(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)