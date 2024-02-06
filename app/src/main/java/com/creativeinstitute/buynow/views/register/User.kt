package com.creativeinstitute.buynow.views.register

data class User(
    var name: String,
    var email: String,
    val password: String,
    val userType: String,
    val userID: String
)
