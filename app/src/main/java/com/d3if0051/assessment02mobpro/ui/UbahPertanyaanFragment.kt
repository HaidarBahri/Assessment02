package com.d3if0051.assessment02mobpro.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.d3if0051.assessment02mobpro.MainAdapter
import com.d3if0051.assessment02mobpro.data.PertanyaanDb
import com.d3if0051.assessment02mobpro.databinding.FragmentUbahPertanyaanBinding
import com.d3if0051.assessment02mobpro.ui.dialog.InsertDialog
import com.d3if0051.assessment02mobpro.viewModels.FirebaseUserViewModel
import com.d3if0051.assessment02mobpro.viewModels.MainViewModel
import com.d3if0051.assessment02mobpro.viewModels.MainViewModelFactory

class UbahPertanyaanFragment : Fragment() {

    private lateinit var binding: FragmentUbahPertanyaanBinding
    private lateinit var myAdapter: MainAdapter

    private val viewModel: MainViewModel by lazy {
        val dataSource = PertanyaanDb.getInstance().dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    private val userViewModel: FirebaseUserViewModel by lazy {
        ViewModelProvider(this)[FirebaseUserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUbahPertanyaanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.authState.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser != null) {

                myAdapter = MainAdapter(childFragmentManager, firebaseUser.uid)
                with(binding.recyclerViewPertanyaan) {
                    addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
                    setHasFixedSize(true)
                    adapter = myAdapter
                }
                viewModel.data.observe(viewLifecycleOwner) {
                    myAdapter.submitList(it)
                    Log.d("get data snapshot: ", it.toString())
                }

                binding.btnAdd.setOnClickListener {
                    InsertDialog(null, firebaseUser.uid).show(
                        childFragmentManager,
                        "InsertDialog"
                    )
                }
            }
        }


    }

//    override fun insertDialog(pertanyaan: Pertanyaan) {
//        viewModel.insertData(pertanyaan)
//    }
//
//    override fun updateDialog(pertanyaan: Pertanyaan) {
//        viewModel.updateData(pertanyaan)
//    }
//
//    override fun deleteDialog(pertanyaan: Pertanyaan) {
//        viewModel.deleteData(pertanyaan.id)
//    }
}