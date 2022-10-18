package com.mobile.test.domain


abstract class UseCaseSuspend<out Type, in Params> where Type : Any? {
    abstract suspend fun run(params: Params? = null): Type

    @JvmOverloads
    suspend operator fun invoke(
        params: Params? = null
    ): Type = run(params)
}