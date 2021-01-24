package com.example.stcchallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stcchallenge.R
import com.example.stcchallenge.databinding.CellSenatorBinding
import com.example.stcchallenge.models.Senator
import java.util.*


class SenatorsAdapter : RecyclerView.Adapter<SenatorsAdapter.ItemViewHolder>() {
    private val items = ArrayList<Senator>()
    internal var onSenatorClick: ((Senator) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SenatorsAdapter.ItemViewHolder {
        val context = parent.context
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.cell_senator, parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: SenatorsAdapter.ItemViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    internal fun updateList(newItems: ArrayList<Senator>) {
        newItems.sortBy { it.person?.lastname }
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    internal fun isEmpty(): Boolean = items.isEmpty()

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(private val binding: CellSenatorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(senator: Senator) {
            binding.senator = senator
            binding.root.setOnClickListener { onSenatorClick?.invoke(senator) }

        }
    }

}