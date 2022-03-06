package com.example.navigationtask.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navigationtask.databinding.MainFragmentBinding
import com.example.navigationtask.infrastructure.database.DatabaseClick
import com.example.navigationtask.infrastructure.model.Click
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
@AndroidEntryPoint
class MainFragment() : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.leftButton.setOnClickListener {
           viewModel.addNewClick(Click(null,"Left button",getDate()))
        }

        binding.rightButton.setOnClickListener {

            viewModel.addNewClick(Click(null,"Right button",getDate()))
        }

    }
    fun getDate():String {
        return SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Date()).toString()
    }
}