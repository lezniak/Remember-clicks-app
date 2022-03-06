package com.example.navigationtask.ui.secondFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationtask.databinding.SecondFragmentBinding
import com.example.navigationtask.infrastructure.model.Click
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class secondFragment : Fragment() {
    lateinit var binding: SecondFragmentBinding
    private val viewModel: secondViewModel by viewModels()
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(requireContext())
        viewModel.clicksList.observe(viewLifecycleOwner) { it ->
            if(!it.isEmpty()){
                binding.noDataText.visibility = View.INVISIBLE
                setupRecycleView(it)
            }
        }
    }

    private fun setupRecycleView(list : List<Click>){
        val adapter = secondAdapter(list.reversed(),requireContext())
        binding.recycleview.adapter = adapter
        binding.recycleview.layoutManager = layoutManager
    }

}