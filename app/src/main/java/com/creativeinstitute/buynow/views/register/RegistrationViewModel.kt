package com.creativeinstitute.buynow.views.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeinstitute.buynow.core.DataState
import com.creativeinstitute.buynow.data.AuthService

class RegistrationViewModel: ViewModel(){

    private val _registrationResponse = MutableLiveData<DataState<User>>()
    val registrationResponse: LiveData<DataState<User>> = _registrationResponse



    fun userRegistration(user:User){
        _registrationResponse.postValue(DataState.Loading())
        val authService = AuthService()
        authService.userRegistration(user)


            .addOnSuccessListener {
                _registrationResponse.postValue(DataState.Success(user))


        }
            .addOnFailureListener{error ->
                _registrationResponse.postValue(DataState.Error(error.message))

        }
    }
}