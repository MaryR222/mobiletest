package com.mobile.test.data.listCard

import com.mobile.test.domain.Failure
import com.mobile.test.domain.functional.Either
import com.mobile.test.domain.listCard.GetListCardRepopsitory
import com.mobile.test.domain.listCard.ListCardBusiness

class GetListCardRepositoryImpl(private val dataSource: ListCardDataSource) :
    GetListCardRepopsitory {
    override suspend fun getListCar(): Either<Failure, ListCardBusiness> {
        dataSource.getListCard()
            .fold({ return Either.Right(ListCardBusiness(list = emptyList())) },
                { return Either.Right(it.toDomain()) })
    }
}