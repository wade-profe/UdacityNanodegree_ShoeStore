package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(emptyList())

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList
    val sizeString: MutableLiveData<String> = MutableLiveData("")
    val newShoe = MutableLiveData(Shoe("", 0.0, "", ""))

    fun addShoe(): Boolean{
        newShoe.value?.let {
            if(it.name.isEmpty() || sizeString.value!!.isEmpty() || it.company.isEmpty()){
                return false
            } else {
                it.size = sizeString.value?.toDouble() ?: 0.0
                _shoeList.value = _shoeList.value?.plus(newShoe.value!!)
                newShoe.value = Shoe("", 0.0, "", "")
                sizeString.value = ""
                return true
            }
        }
        return false
    }
}