package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding

class ShoeDetailsFragment: Fragment() {

    lateinit var shoeDetailsFragmentBinding: ShoeDetailsFragmentBinding
    val shoeListViewModel:ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_details_fragment, container, false)

        shoeDetailsFragmentBinding.viewModel = shoeListViewModel

        shoeDetailsFragmentBinding.cancelButton.setOnClickListener { findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment) }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        return shoeDetailsFragmentBinding.root

    }
}