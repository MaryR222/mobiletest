package com.mobile.test.domain.listCard

import com.mobile.test.domain.Failure
import com.mobile.test.domain.UseCaseSuspend
import com.mobile.test.domain.functional.Either
import javax.inject.Inject


class GetListCard @Inject constructor(private val repository: GetListCardRepopsitory) :
    UseCaseSuspend<Either<Failure, ListCardBusiness>, Unit>() {
    override suspend fun run(params: Unit?): Either<Failure, ListCardBusiness> {
        return repository.getListCar()
    }
}