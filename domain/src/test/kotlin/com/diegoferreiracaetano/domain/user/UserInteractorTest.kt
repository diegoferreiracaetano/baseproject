package com.diegoferreiracaetano.domain.user

import com.diegoferreiracaetano.domain.Mock.users
import com.diegoferreiracaetano.router.user.UserRouter
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class UserInteractorTest {

    private val repository = mockk<UserRepository>()
    private val router = mockk<UserRouter>()
    private lateinit var interactor: UserInteractor

    @Before
    fun setUp() {
        interactor = UserInteractor(repository, router)
    }

    @Test
    fun `Given repository, When calling users, Then assert values`() {

        runBlocking {

            coEvery { repository.users() } returns flowOf(users())

            val result = interactor(Unit)

            assertEquals(result, users())
        }
    }
}
