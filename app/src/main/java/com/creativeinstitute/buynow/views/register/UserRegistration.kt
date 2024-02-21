package com.creativeinstitute.buynow.views.register

data class UserRegistration(
    var name: String,
    var email: String,
    val password: String,
    val userType: String,
    var userID: String
)
