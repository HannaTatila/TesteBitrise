package com.example.testebitrise.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testebitrise.R
import com.example.testebitrise.di.ComicsModule
import kotlinx.android.synthetic.main.activity_details_comic.*

class DetailsComicActivity : AppCompatActivity() {

    private val viewModel = ComicsModule.viewModelDetailsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_comic)

        getComic()
        handleState()
    }

    private fun getComic() {
        val idComic = intent.getIntExtra(ARG_ID_COMIC, 0)
        if(idComic != 0) viewModel.getComicById(idComic)
    }


    private fun handleState() {
        viewModel.comicViewState.observe(this, Observer { comicViewState ->
//            progressDetailComic.visibility = if(comicViewState.isLoading) View.VISIBLE else View.INVISIBLE

            textTitleDetailComic.text = comicViewState.comic?.title
            textDescriptionDetailComic.text = comicViewState.comic?.description
        })
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