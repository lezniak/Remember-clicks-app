package com.example.navigationtask.ui.thirdFragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.navigationtask.databinding.ThirdFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
@AndroidEntryPoint
class thirdFragment: Fragment() {
    private val viewModel: thirdViewModel by viewModels()
    lateinit var binding: ThirdFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdFragmentBinding.inflate(layoutInflater)

        binding.ClearClicks.setOnClickListener {
            viewModel.clearClicks()
        }
    }
}