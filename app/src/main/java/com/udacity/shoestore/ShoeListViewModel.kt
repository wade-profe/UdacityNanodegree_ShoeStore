package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.lang.Double.parseDouble

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(emptyList())

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    val sizeString: MutableLiveData<String> = MutableLiveData("")
    private val sizeDouble: LiveData<Double> = sizeString.map { size -> makeDouble(size)}
    val newShoe = MutableLiveData(Shoe("", sizeDouble.value ?: 0.0, "", ""))

    fun makeDouble(input: String): Double {
        if(input.isNotEmpty()) {
            return input.toDouble()
        } else {
            return 0.0
        }
    }

    fun addShoe(){
        _shoeList.value?.plus(newShoe)
        newShoe.value = Shoe("", sizeDouble.value ?: 0.0, "", "")
    }
}