package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>().apply { value = mutableListOf(Shoe("Test1", 9.0, "Nike", "a Nike shoe"),
        Shoe("Test2", 5.0, "Adidas", "an Adidas shoe"), Shoe("Test3", 7.5, "Puma", "a Puma shoe")) }

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

}