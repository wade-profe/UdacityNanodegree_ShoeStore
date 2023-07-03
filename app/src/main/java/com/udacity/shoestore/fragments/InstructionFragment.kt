package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionFragment: Fragment() {

    lateinit var instructionFragmentBinding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        instructionFragmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.instructions_fragment, container, false)

        instructionFragmentBinding.continueButton.setOnClickListener { findNavController().navigate(
            R.id.action_instructionFragment_to_shoeListFragment
        ) }

        return instructionFragmentBinding.root
    }
}