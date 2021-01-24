package com.example.stcchallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stcchallenge.R
import com.example.stcchallenge.databinding.FragmentSenatorDetailsBinding
import com.example.stcchallenge.models.Senator
import com.example.stcchallenge.ui.fragments.senatorsList.SenatorsListFragment.Companion.ARG_SENATOR


class SenatorDetailsFragment : Fragment() {

    private val argSenator: Senator by lazy {
        (arguments?.getSerializable(ARG_SENATOR) as? Senator) ?: Senator()
    }
    private lateinit var binding: FragmentSenatorDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_senator_details, container, false
        )
        binding.senator = argSenator
        return binding.root
    }
}