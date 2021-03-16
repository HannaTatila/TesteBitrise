package com.example.testebitrise.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testebitrise.R
import com.example.testebitrise.domain.model.Characters
import kotlinx.android.synthetic.main.item_list_characters.view.*

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var characterList: List<Characters> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewTipo: Int): CharactersViewHolder {
        val context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_list_characters, parent, false)

        return CharactersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }

    override fun onBindViewHolder(charactersViewHolder: CharactersViewHolder, position: Int) {
        charactersViewHolder.bindView(characterList[position])
    }

    fun setList(characterList: List<Characters>) {
        this.characterList = characterList
        notifyDataSetChanged()
    }

    class CharactersViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val viewName = itemView.textNameCharacter

        fun bindView(character: Characters) {
            viewName.text = character.name
        }
    }
}
