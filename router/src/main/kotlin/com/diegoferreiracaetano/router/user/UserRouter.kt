package com.diegoferreiracaetano.router.user

import com.diegoferreiracaetano.router.Router

class UserRouter : Router {

    override fun navigate(any: Any) = "android-app://user/id/$any"
    override fun isStart(): Boolean = true
}
