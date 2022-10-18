package com.mobile.test.data.listCard

import com.mobile.test.domain.listCard.ListCardBusiness

data class ListCardResponse( val list: List<CardResponse>)

fun ListCardResponse.toDomain(): ListCardBusiness {
    return ListCardBusiness(list = list.map { it.toDomain() })
}
