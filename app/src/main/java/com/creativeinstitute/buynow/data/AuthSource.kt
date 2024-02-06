package com.creativeinstitute.buynow.data

import com.creativeinstitute.buynow.views.register.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {

    fun userRegistration(user: User) : Task<AuthResult>

    fun userLogin(user: User)

}