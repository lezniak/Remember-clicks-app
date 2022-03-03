package com.example.navigationtask.ui.secondFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationtask.databinding.SecondFragmentBinding

class secondFragment : Fragment() {
    lateinit var binding: SecondFragmentBinding
    lateinit var viewModel: secondViewModel
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
        viewModel = ViewModelProvider(this)[secondViewModel::class.java]
        layoutManager = LinearLayoutManager(requireContext())
        viewModel.clicksList.observe(viewLifecycleOwner) { it ->
            setupRecycleView()
        }
    }

    private fun setupRecycleView(){
        val adapter = secondAdapter(viewModel.clicksList.value!!,requireContext())
        binding.recycleview.adapter = adapter
        binding.recycleview.layoutManager = layoutManager
    }

}