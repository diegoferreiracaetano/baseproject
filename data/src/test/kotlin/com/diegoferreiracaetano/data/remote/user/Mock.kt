package com.diegoferreiracaetano.data.remote.user

internal object Mock {

    fun userEntity() = OrderEntity(1, "Diego", "@diego", "http:://www.google.com")

    fun listUserEntity() = listOf(userEntity())
}
