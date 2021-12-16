package com.dapps.mvvmbasic.repository

import android.telecom.Call
import android.util.Log
import com.dapps.mvvmbasic.model.Character

import androidx.lifecycle.MutableLiveData
import com.dapps.mvvmbasic.model.CharacterResults
import com.dapps.mvvmbasic.network.APIRequest
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    // This class responsible for getting the data from the server and pass it to the ViewModel.
    // Next Class is MainViewModel


    // This is the function that actually make the request to the server and get the data from it.
    // MutableLiveData - Meaning that this data can change and its not final.
    // LiveData - Meaning that this data is final and you *can't* change it!
    // So we first getting the list as a mutableData and in the next class we will return it as LiveData.
    fun requestCharacters(): MutableLiveData<List<Character>> {

        val mutableLiveData = MutableLiveData<List<Character>>()

        val startApi = APIRequest.getCharacterListFromAPI.getAllCharacters(1)

        startApi.enqueue(object : Callback<CharacterResults?> {
            override fun onResponse(
                call: retrofit2.Call<CharacterResults?>,
                response: Response<CharacterResults?>
            ) {

                if (response.isSuccessful){ // Request Successful
                    mutableLiveData.value = response.body()?.resultsList
                    Log.e("Success","Success" + response.body()?.resultsList)
                }

            }

            override fun onFailure(call: retrofit2.Call<CharacterResults?>, t: Throwable) {
                Log.e("Failed","Failed ${t.message}") // Request Failed
            }
        })
        return mutableLiveData // Returning the mutableLiveData after getting the list.

    }
}