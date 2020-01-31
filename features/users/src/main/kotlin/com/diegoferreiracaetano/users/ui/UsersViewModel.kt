package com.diegoferreiracaetano.users.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.diegoferreiracaetano.domain.user.UserInteractor

internal class UsersViewModel(
    private val userInteractor: UserInteractor
) : ViewModel() {

    fun users() = userInteractor(Unit).asLiveData()
}
