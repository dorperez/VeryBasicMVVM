package com.dapps.mvvmbasic.network

import android.telecom.Call
import com.dapps.mvvmbasic.model.CharacterResults
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// In this class we using retrofit in order to communicate with the Api and get the data from it.
// Next is MainRepository

    object APIRequest {

        private val baseURL = "https://rickandmortyapi.com/api/" // Base Url

        private var retrofit = Retrofit.Builder() // Setting up retrofit
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getCharacterListFromAPI: APICallRequest = retrofit.create(APICallRequest::class.java) // Make the request

    }

    interface APICallRequest{ // Define page number and make the retrofit call based on CharacterResults format

        @GET("character")
        fun getAllCharacters(@Query("page") page: Int) : retrofit2.Call<CharacterResults>
    }

