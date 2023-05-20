package com.d3if0051.assessment02mobpro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.d3if0051.assessment02mobpro.R
import com.d3if0051.assessment02mobpro.databinding.FragmentMainmenuBinding
import com.d3if0051.assessment02mobpro.viewModels.FirebaseUserViewModel
import com.firebase.ui.auth.AuthUI

class MainmenuFragment : Fragment() {
    private lateinit var binding: FragmentMainmenuBinding

    private val viewModel: FirebaseUserViewModel by lazy {
        ViewModelProvider(this)[FirebaseUserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainmenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMain.setOnClickListener {
            findNavController().navigate(R.id.action_mainmenuFragment_to_playPertanyaanFragment)
        }
        binding.btnUbahPertanyaan.setOnClickListener {
            findNavController().navigate(R.id.action_mainmenuFragment_to_ubahPertanyaanFragment)
        }
        binding.btnAbout.setOnClickListener {
            findNavController().navigate(R.id.action_mainmenuFragment_to_aboutFragment)
        }
        binding.btnLogout.setOnClickListener {
            AuthUI.getInstance().signOut(requireContext())
        }
        binding.btnExit.setOnClickListener { requireActivity().finish() }

        viewModel.authState.observe(viewLifecycleOwner) {
            if (it == null) {
                findNavController().navigate(R.id.action_mainmenuFragment_to_loginFragment)
            }
        }
    }
}