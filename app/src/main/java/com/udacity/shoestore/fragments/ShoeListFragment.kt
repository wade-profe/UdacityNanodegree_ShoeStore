package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.EmptyShoeListBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeListFragment: Fragment() {

    lateinit var shoeListBinding: ShoeListFragmentBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        setHasOptionsMenu(true)

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            if (shoeList.isEmpty()) {
                val emptyShoeListBinding = EmptyShoeListBinding.inflate(
                    layoutInflater,
                    shoeListBinding.shoeListLinearLayout,
                    false
                )
                shoeListBinding.shoeListLinearLayout.addView(emptyShoeListBinding.root)
            } else {
                shoeList.forEach { shoe ->
                    val shoeListItemBinding = ShoeListItemBinding.inflate(
                        layoutInflater,
                        shoeListBinding.shoeListLinearLayout,
                        false
                    )
                    shoeListItemBinding.shoe = shoe
                    shoeListBinding.shoeListLinearLayout.addView(shoeListItemBinding.root)
                }
            }

        }

        shoeListBinding.fab.setOnClickListener { findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment) }



        return shoeListBinding.root

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return true
    }



}