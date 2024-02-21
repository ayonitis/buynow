package com.creativeinstitute.buynow.views.register

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.base.BaseFragment
import com.creativeinstitute.buynow.core.DataState
import com.creativeinstitute.buynow.databinding.FragmentRegisterBinding
import com.creativeinstitute.buynow.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {


    val viewModel: RegistrationViewModel by viewModels()


    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
                is DataState.Loading -> {
                    loading.show()
                    Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "Created User: ${it.data}", Toast.LENGTH_LONG).show()

                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
            }
        }
    }


    override fun setPreviousAccount() {
        with(binding) {
            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
            }
        }
    }

    override fun setListener() {
        with(binding){
            btnRegister.setOnClickListener{
                etName.isEmpty() == false
                etEmail.isEmpty() == false
                etPassword.isEmpty() == false

                if(!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context, "Please Login To Continue!", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)


                    val user = UserRegistration(etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistration(user)

                }
            }
        }
    }

    override fun allObserver() {
        registrationObserver()

    }
}