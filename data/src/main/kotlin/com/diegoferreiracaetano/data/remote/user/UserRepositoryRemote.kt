package com.diegoferreiracaetano.data.remote.user

import com.diegoferreiracaetano.data.remote.RemoteApi
import com.diegoferreiracaetano.domain.user.User
import com.diegoferreiracaetano.domain.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserRepositoryRemote(private val api: RemoteApi) : UserRepository {

    override fun users(): Flow<List<User>> = api.users().map { it.transform() }
}
