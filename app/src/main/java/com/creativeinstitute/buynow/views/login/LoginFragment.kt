package com.creativeinstitute.buynow.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.databinding.FragmentLoginBinding
import com.creativeinstitute.buynow.isEmpty


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setLoginListener()
        setNewAccountListener()
        return binding.root
    }

    private fun setNewAccountListener() {
        with(binding) {
            btnSignUp.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
        }
    }

    private fun setLoginListener() {
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
}