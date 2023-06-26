package com.udacity.shoestore

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment: Fragment() {

    private lateinit var welcomeFragmentBinding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        welcomeFragmentBinding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment) }

        return welcomeFragmentBinding.root
    }
}