package com.d3if0051.assessment02mobpro.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.d3if0051.assessment02mobpro.data.Pertanyaan
import com.d3if0051.assessment02mobpro.data.PertanyaanDb
import com.d3if0051.assessment02mobpro.databinding.DialogDeleteBinding
import com.d3if0051.assessment02mobpro.viewModels.MainViewModel
import com.d3if0051.assessment02mobpro.viewModels.MainViewModelFactory

class DeleteDialog(private val data: Pertanyaan) : DialogFragment() {
    private lateinit var binding: DialogDeleteBinding
    private val viewModel: MainViewModel by lazy {
        val dataSource = PertanyaanDb.getInstance().dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = layoutInflater
        binding = DialogDeleteBinding.inflate(inflater, null, false)

        val builder = AlertDialog.Builder(requireContext()).apply {
            setView(binding.root)
        }
        binding.btnCancel.setOnClickListener { dismiss() }
        binding.btnDelete.setOnClickListener {
//            val listener = parentFragment as DialogListener
//            listener.deleteDialog(data)
            viewModel.deleteData(data.id)
            dismiss()
        }
        return builder.create()
    }
}