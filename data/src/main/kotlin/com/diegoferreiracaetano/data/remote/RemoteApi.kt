package com.diegoferreiracaetano.data.remote

import com.diegoferreiracaetano.data.remote.user.UserEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

internal interface RemoteApi {

    @GET("tests/mobdev/users")
    fun users(): Flow<List<UserEntity>>
}
