package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding

class ShoeDetailsFragment: Fragment() {

    lateinit var shoeDetailsFragmentBinding: ShoeDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_details_fragment, container, false)



        return shoeDetailsFragmentBinding.root

    }
}