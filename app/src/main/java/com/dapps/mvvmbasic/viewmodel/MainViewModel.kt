package com.dapps.mvvmbasic.viewmodel

import androidx.lifecycle.ViewModel
import com.dapps.mvvmbasic.model.Character

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.dapps.mvvmbasic.repository.MainRepository


class MainViewModel : ViewModel() {

    // The ViewModel class holds all the logic of the app and then transfer it to the activity.
    // Next Class Is The MainActivity

    private var mutableLiveData: MutableLiveData<List<Character>>? = null

    // In this function we getting the data as MutableLiveData(Data that can Change)
    // And we return it as LiveData(Data that *can't* be change) to display it to the user.
    fun getCharacters(): LiveData<List<Character>> {
        if (mutableLiveData == null) {
            mutableLiveData = MainRepository().requestCharacters()
        }
        return mutableLiveData as LiveData<List<Character>>
    }

}