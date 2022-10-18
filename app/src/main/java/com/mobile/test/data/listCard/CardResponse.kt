package com.mobile.test.data.listCard

import com.mobile.test.domain.listCard.CardBusiness

data class CardResponse(
    val id: Int,
    val typeCard: TypeCard,
    val creditDebt: Double,
    val creditEnable: Double,
    val creditLimit: Double,
    val pan: String,
    val holderType: String,
    val clientName: String,
    val activeCard: Boolean
) {
    enum class TypeCard(val nameTypeCard: String) {
        VISA("Crédito Visa"),
        MASTER("Crédito Master")
    }
}

fun CardResponse.toDomain(): CardBusiness {
    return CardBusiness(
        id = id,
        clientName = clientName,
        creditEnable = creditEnable,
        creditDebt = creditDebt,
        typeCard = typeCard.nameTypeCard,
        activeCard = activeCard,
        creditLimit = creditLimit,
        pan = pan,
        holderType = holderType
    )
}