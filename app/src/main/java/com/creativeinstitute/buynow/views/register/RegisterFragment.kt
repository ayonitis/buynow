package com.creativeinstitute.buynow.views.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.core.DataState
import com.creativeinstitute.buynow.databinding.FragmentRegisterBinding
import com.creativeinstitute.buynow.isEmpty
import com.creativeinstitute.buynow.views.dashboard.DashboardFragment
import com.creativeinstitute.buynow.views.login.LoginFragment

class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding

    val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentRegisterBinding.inflate(inflater, container, false)
        setListener()
        setPreviousAccount()

        registrationObserver()

        return binding.root
    }

    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                is DataState.Loading -> Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                is DataState.Success -> Toast.makeText(context, "Created User: ${it.data}", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun setPreviousAccount() {
        with(binding) {
            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
            }
        }
    }

    private fun setListener() {
        with(binding){
            btnRegister.setOnClickListener{
                etName.isEmpty() == false
                etEmail.isEmpty() == false
                etPassword.isEmpty() == false

                if(!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context, "Please Login To Continue!", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)


                    val user = User(etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(), "Seller", ""
                    )

                    viewModel.userRegistration(user)

                }
            }
        }
    }
}