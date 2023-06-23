package com.udacity.shoestore

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private lateinit var loginFragmentBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater, container, false)
        return loginFragmentBinding!!.root
    }
}