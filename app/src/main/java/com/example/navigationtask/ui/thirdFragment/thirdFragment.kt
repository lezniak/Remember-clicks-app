package com.example.navigationtask.ui.thirdFragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navigationtask.databinding.ThirdFragmentBinding

class thirdFragment: Fragment() {
    lateinit var viewModel: thirdViewModel
    lateinit var binding: ThirdFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ThirdFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[thirdViewModel::class.java]
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}