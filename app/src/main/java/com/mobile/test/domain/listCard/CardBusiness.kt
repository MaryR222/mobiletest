package com.mobile.test.domain.listCard

data class CardBusiness (
    val id: Int,
    val typeCard: String,
    val creditDebt: Double,
    val creditEnable: Double,
    val creditLimit: Double,
    val pan: String,
    val holderType: String,
    val clientName: String,
    val activeCard: Boolean
)
