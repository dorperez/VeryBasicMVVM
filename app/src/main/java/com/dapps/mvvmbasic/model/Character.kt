package com.dapps.mvvmbasic.model

import com.google.gson.annotations.SerializedName

// Next is the ApiRequest in Network Package

// This is the model class,its represent one character from rick and morty.
data class Character(

    @SerializedName("name")
    val characterName: String,

    @SerializedName("species")
    val characterSpecie: String,

    @SerializedName("status")
    val characterStatus: String,

    @SerializedName("image")
    val characterImage: String


)

data class CharacterResults(
    @SerializedName("results")
    var resultsList: List<Character>
)

// In the json api below you can see there is a "results" array that holds all the characters, and all
// the characteristics of the character.
// So in order to get a single character we first need to get all the characters to a List<Character>(= List Of Characters)
// And that is why we have CharacterResults and we need to call it first.

// -------------- Json From API ----------------
//"results": [
//{
//    "id": 1,
//    "name": "Rick Sanchez",
//    "status": "Alive",
//    "species": "Human",
//    "type": "",
//    "gender": "Male",
//    "origin": {
//    "name": "Earth",
//    "url": "https://rickandmortyapi.com/api/location/1"
//    "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
//}