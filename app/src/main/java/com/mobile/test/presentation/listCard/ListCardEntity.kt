package com.mobile.test.presentation.listCard

import com.mobile.test.domain.listCard.ListCardBusiness

data class ListCardEntity(val list: List<CardEntity> = emptyList())

fun ListCardBusiness.toPresentation(): ListCardEntity {
    return ListCardEntity(list = list.map { it.toPresentation() })
}
