package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding

class ShoeListFragment: Fragment() {

    lateinit var shoeListBinding: ShoeListFragmentBinding
    val shoeListViewModel:ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) {shoeList ->
            shoeList.forEach {shoe ->
                val shoeListItemBinding = ShoeListItemBinding.inflate(layoutInflater, null, false)
                shoeListItemBinding.shoe = shoe
                shoeListBinding.shoeListLinearLayout.addView(shoeListItemBinding.root)
            }
        }

        return shoeListBinding.root

    }
}