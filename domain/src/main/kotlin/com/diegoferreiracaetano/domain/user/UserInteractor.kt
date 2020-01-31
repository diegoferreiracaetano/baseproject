package com.diegoferreiracaetano.domain.user

import com.diegoferreiracaetano.domain.Interactor
import com.diegoferreiracaetano.domain.ResultRouter
import com.diegoferreiracaetano.router.Router
import kotlinx.coroutines.flow.map

class UserInteractor(
    private val userRepository: UserRepository,
    private val router: Router
) : Interactor<Unit, ResultRouter<List<User>>>() {

    override fun execute(parameters: Unit) = userRepository.users().map {
        ResultRouter.add(it, router)
    }
}
