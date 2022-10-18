package com.mobile.test.domain.listCard

import com.mobile.test.domain.Failure
import com.mobile.test.domain.functional.Either

interface GetListCardRepopsitory {
    suspend fun getListCar(): Either<Failure, ListCardBusiness>
}
