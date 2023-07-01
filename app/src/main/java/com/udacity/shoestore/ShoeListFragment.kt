package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.EmptyShoeListBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import timber.log.Timber

class ShoeListFragment: Fragment() {

    lateinit var shoeListBinding: ShoeListFragmentBinding
    val shoeListViewModel:ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        setHasOptionsMenu(true)

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            if (shoeList.size == 0) {
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return true
    }



}