package com.example.testebitrise.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testebitrise.R
import com.example.testebitrise.domain.model.Comic
import kotlinx.android.synthetic.main.item_list_comics.view.*

class ComicsAdapter(
    private val listComics: List<Comic>,
    private val click: (idComic: Int) -> Unit
) :
    RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {

    override fun onCreateViewHolder(pai: ViewGroup, viewTipo: Int): ComicsViewHolder {
        val context = pai.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_comics, pai, false)

        return ComicsViewHolder(view, click)
    }

    override fun getItemCount(): Int {
        return listComics.count()
    }

    override fun onBindViewHolder(contatosViewHolder: ComicsViewHolder, position: Int) {
        contatosViewHolder.bindView(listComics[position])
    }

    class ComicsViewHolder(
        itemView: View,
        private val click: (idComic: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val viewTitle = itemView.textComicTitle
        private val viewReleaseDate = itemView.textComicReleaseDate
        private val viewDescription = itemView.textComicDescription

        fun bindView(comic: Comic) {
            viewTitle.text = comic.title
            viewReleaseDate.text = comic.releaseDate
            viewDescription.text = comic.description

            itemView.setOnClickListener { click.invoke(comic.id) }
        }
    }
}
