package com.example.testebitrise.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testebitrise.R
import com.example.testebitrise.di.ComicsModule
import com.example.testebitrise.domain.model.Comic
import kotlinx.android.synthetic.main.activity_details_comic.*

class DetailsComicActivity : AppCompatActivity() {

    private val viewModel = ComicsModule.viewModelDetailsInstance
    private val charactersAdapter = CharactersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_comic)


        with(recyclerComics) {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(this@DetailsComicActivity)
        }

        getComic()
        handleState()
    }

    private fun getComic() {
        val idComic = intent.getIntExtra(ARG_ID_COMIC, 0)
        if (idComic != 0) viewModel.getComicById(idComic)
    }

    private fun handleState() {
        viewModel.comicViewState.observe(this, Observer { comicViewState ->
            if (comicViewState.isLoading) {
                progressDetailComic.visibility = View.VISIBLE
            } else {
                progressDetailComic.visibility = View.INVISIBLE
            }

            if (comicViewState.comic != null) {
                configureView(comicViewState.comic)
                loadingContentGroup.visibility = View.VISIBLE
            }

            if(comicViewState.characters.isNotEmpty()){
                charactersAdapter.setList(comicViewState.characters)
                recyclerComics.visibility = View.VISIBLE
            }
        })
    }

    private fun configureView(comic: Comic) {
        textTitleDetailComic.text = comic.title
        textDateDetailComic.text = comic.releaseDate
        textDescriptionDetailComic.text = comic.description
    }

    companion object {
        private const val ARG_ID_COMIC = "ARG_ID_COMIC"

        fun newInstance(context: Context, idComic: Int): Intent {
            return Intent(context, DetailsComicActivity::class.java).apply {
                putExtra(ARG_ID_COMIC, idComic)
            }
        }
    }
}
