package com.creativeinstitute.buynow.data

import com.creativeinstitute.buynow.core.Nodes
import com.creativeinstitute.buynow.views.register.UserRegistration
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository(private val mAuth: FirebaseAuth,
                     private val db: FirebaseFirestore)
    : AuthSource {

    override fun userRegistration(user: UserRegistration): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: UserRegistration) {
        TODO("Not yet implemented")
    }

    override fun userForgetPassword(email: String) {
        TODO("Not yet implemented")
    }

    override fun createUser(user: UserRegistration): Task<Void> {
        return db.collection(Nodes.USER).document(user.userID).set(user)
    }
}