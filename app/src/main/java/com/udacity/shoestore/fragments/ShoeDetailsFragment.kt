package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeDetailsFragment: Fragment() {

    lateinit var shoeDetailsFragmentBinding: ShoeDetailsFragmentBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeDetailsFragmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.shoe_details_fragment, container, false)

        shoeDetailsFragmentBinding.viewModel = shoeListViewModel

        shoeDetailsFragmentBinding.cancelButton.setOnClickListener { findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment) }

        shoeDetailsFragmentBinding.saveButton.setOnClickListener {
            val result = shoeListViewModel.addShoe()
            if(result){
                findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
            } else{
                Toast.makeText(requireContext(), "Invalid input. Please enter name, size and company", Toast.LENGTH_LONG).show()
            }
        }

        return shoeDetailsFragmentBinding.root

    }
}