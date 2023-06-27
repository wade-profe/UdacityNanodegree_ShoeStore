package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment: Fragment() {

    lateinit var shoeListBinding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        return shoeListBinding.root


    }
}