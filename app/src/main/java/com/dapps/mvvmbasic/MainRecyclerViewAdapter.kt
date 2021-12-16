package com.dapps.mvvmbasic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dapps.mvvmbasic.model.Character

class MainRecyclerViewAdapter(private var charactersList : List<Character>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.CharacterViewHolder>() {

    lateinit var context : Context

    inner class CharacterViewHolder(private var itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(character : Character) {

            val characterName = itemView.findViewById<TextView>(R.id.characterNameValue)
            val characterPhoto = itemView.findViewById<ImageView>(R.id.characterImageView)
            val characterStatus = itemView.findViewById<TextView>(R.id.statusValue)
            val characterSpecie = itemView.findViewById<TextView>(R.id.speciesValue)


            characterName.text = character.characterName
            characterStatus.text = character.characterStatus
            characterSpecie.text = character.characterSpecie

            Glide.with(context).load(character.characterImage).into(characterPhoto)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        context = parent.context.applicationContext
        return CharacterViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_row,parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}