package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionFragment: Fragment() {

    lateinit var instructionFragmentBinding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        instructionFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)

        return instructionFragmentBinding.root
    }
}