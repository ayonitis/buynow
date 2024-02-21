package com.creativeinstitute.buynow.views.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeinstitute.buynow.R
import com.creativeinstitute.buynow.base.BaseFragment
import com.creativeinstitute.buynow.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellerDashboardFragment : BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    @Inject
    lateinit var mAuth: FirebaseAuth

    override fun setListener() {
        binding.apply {
            btnLogout.setOnClickListener{
                mAuth.signOut()
                findNavController().navigate(R.id.action_dashboardFragment_to_startFragment)
                Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_LONG).show()
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