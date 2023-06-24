package com.udacity.shoestore

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment: Fragment() {

    private lateinit var welcomeFragmentBinding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welcomeFragmentBinding = WelcomeFragmentBinding.inflate(inflater, container, false)
        return welcomeFragmentBinding.root
    }
}