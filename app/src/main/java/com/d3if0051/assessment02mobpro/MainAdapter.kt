package com.d3if0051.assessment02mobpro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.d3if0051.assessment02mobpro.data.Pertanyaan
import com.d3if0051.assessment02mobpro.databinding.ItemPertanyaanBinding
import com.d3if0051.assessment02mobpro.ui.dialog.DeleteDialog
import com.d3if0051.assessment02mobpro.ui.dialog.InsertDialog

class MainAdapter(
    private val fragmentManager: FragmentManager,
    private val userId: String
) : ListAdapter<Pertanyaan, MainAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pertanyaan>() {
            override fun areItemsTheSame(oldItem: Pertanyaan, newItem: Pertanyaan): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Pertanyaan, newItem: Pertanyaan): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPertanyaanBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPertanyaanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pertanyaan: Pertanyaan) {
            binding.textViewPertanyaan.text = pertanyaan.pertanyaan
            binding.btnDelete.setOnClickListener {
//                viewModel.deleteData(pertanyaan.id)
                DeleteDialog(pertanyaan).show(fragmentManager, "DeleteDialog")
            }
            binding.btnEdit.setOnClickListener {
                InsertDialog(pertanyaan, userId).show(fragmentManager, "InsertDialog")
            }
        }
    }
}