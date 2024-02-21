package com.creativeinstitute.buynow.data

import com.creativeinstitute.buynow.views.register.UserRegistration
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {

    fun userRegistration(user: UserRegistration) : Task<AuthResult>

    fun userLogin(user: UserRegistration)

    fun userForgetPassword(email: String)

    fun createUser(user: UserRegistration) : Task<Void>

}