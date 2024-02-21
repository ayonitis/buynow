package com.creativeinstitute.buynow.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.base.BaseFragment
import com.creativeinstitute.buynow.databinding.FragmentLoginBinding
import com.creativeinstitute.buynow.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private fun setNewAccountListener() {
        with(binding) {
            btnSignUp.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
        }
    }

    override fun setListener() {
        with(binding) {
            btnLogin.setOnClickListener {
                etEmail.isEmpty() == false
                etPassword.isEmpty() == false

                if (!etEmail.isEmpty() && !etPassword.isEmpty()) {
                    Toast.makeText(context, "Successful!", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
            }
        }
    }

    override fun setPreviousAccount() {
        TODO("Not yet implemented")
    }

    override fun allObserver() {
        TODO("Not yet implemented")
    }
}
