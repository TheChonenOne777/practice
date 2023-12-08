package com.example.practice.features.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practice.databinding.ItemListBinding
import com.example.practice.entity.MockItem

class ListItemsAdapter : ListAdapter<MockItem, ListItemsAdapter.ListItemViewHolder>(ListItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder =
        LayoutInflater.from(parent.context)
            .let { ItemListBinding.inflate(it, parent, false) }
            .let { ListItemViewHolder(it) }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.binding.itemText.text = getItem(position).text
    }

    class ListItemViewHolder(val binding: ItemListBinding) : ViewHolder(binding.root)
}

class ListItemDiffUtil : DiffUtil.ItemCallback<MockItem>() {

    override fun areItemsTheSame(oldItem: MockItem, newItem: MockItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MockItem, newItem: MockItem): Boolean {
        return oldItem == newItem
    }
}
