package com.example.practice.features.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private val viewModel: ListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = ListItemsAdapter()
        view.findViewById<RecyclerView>(R.id.list_recycler).apply {
            adapter = listAdapter
        }
        lifecycleScope.launch {
            viewModel.listItems.collect { listAdapter.submitList(it) }
        }
    }
}
