package com.creativeinstitute.buynow.views.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.base.BaseFragment
import com.creativeinstitute.buynow.databinding.FragmentStartBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {


    override fun setListener() {

        setupAutoLogin()

        with(binding){
            btnLogin.setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnSignUp.setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }
        }
    }

    private fun setupAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let{
            findNavController().navigate(R.id.action_startFragment_to_dashboardFragment)
        }
    }

    override fun setPreviousAccount() {
        TODO("Not yet implemented")
    }

    override fun allObserver() {
        TODO("Not yet implemented")
    }
}