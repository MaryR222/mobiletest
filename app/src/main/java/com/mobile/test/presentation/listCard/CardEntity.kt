package com.mobile.test.presentation.listCard

import com.mobile.test.domain.listCard.CardBusiness

data class CardEntity (
    val id: Int,
    val typeCard: String,
    val creditDebt: Double,
    val creditEnable: Double,
    val creditLimit: Double,
    val pan: String,
    val holderType: String,
    val clientName: String,
    val activeCard: Boolean,
    val percentage: Double,
    val lastNumber :String
)

fun CardBusiness.toPresentation(): CardEntity {
    return CardEntity(
        id = id,
        clientName = clientName,
        creditEnable = creditEnable,
        creditDebt = creditDebt,
        typeCard = typeCard,
        activeCard = activeCard,
        creditLimit = creditLimit,
        pan = pan,
        holderType = holderType,
        percentage = ((creditDebt*100)/creditLimit),
        lastNumber = pan.takeLast(4)
    )
}