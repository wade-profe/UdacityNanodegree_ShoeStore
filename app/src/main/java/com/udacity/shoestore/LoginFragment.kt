package com.udacity.shoestore

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private lateinit var loginFragmentBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater, container, false)
        return loginFragmentBinding.root
    }

    fun goToWelcome(){
        if(loginFragmentBinding.emailText.text.isNullOrBlank() || loginFragmentBinding.passwordText.text.isNullOrBlank()){
            Toast.makeText(requireContext(), "Please enter an email and password", Toast.LENGTH_SHORT).show()
        } else {
            Navigation.findNavController(loginFragmentBinding.root).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
    }
}