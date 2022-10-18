package com.mobile.test.data.listCard

import com.mobile.test.domain.Failure
import com.mobile.test.domain.functional.Either

class ListCardDataSource {

    fun getListCard(): Either<Failure, ListCardResponse> {

        val list = (1..9).map {
            CardResponse(
                id = it,
                typeCard = if (it % 3 == 0) CardResponse.TypeCard.VISA else CardResponse.TypeCard.MASTER,
                clientName = "Client Name $it",
                creditLimit = 1000.00,
                creditDebt = (it * 100).toDouble(),
                creditEnable = (1000 - it * 100).toDouble(),
                activeCard = it % 3 == 0,
                holderType = if (it % 3 == 0) "Titular" else "Autorizado",
                pan = "1234 5467 8941 444$it"
            )

        }

        return Either.Right(ListCardResponse(list = list))
    }
}