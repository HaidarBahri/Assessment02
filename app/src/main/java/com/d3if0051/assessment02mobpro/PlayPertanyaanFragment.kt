package com.d3if0051.assessment02mobpro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.d3if0051.assessment02mobpro.data.Pertanyaan
import com.d3if0051.assessment02mobpro.data.PertanyaanDb
import com.d3if0051.assessment02mobpro.databinding.FragmentPlayPertanyaanBinding
import com.d3if0051.assessment02mobpro.viewModels.MainViewModel
import com.d3if0051.assessment02mobpro.viewModels.MainViewModelFactory

class PlayPertanyaanFragment : Fragment() {

    private lateinit var binding: FragmentPlayPertanyaanBinding

    private val viewModel: MainViewModel by lazy {
        val dataSource = PertanyaanDb.getInstance().dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    private lateinit var pertanyaan: List<Pertanyaan>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayPertanyaanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnPlay.setOnClickListener {
            if (pertanyaan.isEmpty()) {

                binding.textViewPertanyaan.text = getString(R.string.pertanyaan_kosong)
            } else {
                val pertanyaan: String = pertanyaan.random().pertanyaan
                binding.textViewPertanyaan.text = pertanyaan
            }
        }

        viewModel.data.observe(viewLifecycleOwner) { pertanyaan = it }
    }
}