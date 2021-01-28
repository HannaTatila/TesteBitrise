package com.example.testebitrise.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testebitrise.R
import com.example.testebitrise.di.ComicsModule
import kotlinx.android.synthetic.main.activity_comics.*

class ComicsActivity : AppCompatActivity() {

    private val viewModel = ComicsModule.viewModelInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
        handleState()
        handleAction()
    }

    private fun handleState() {
        viewModel.comicsViewState.observe(this, Observer { comicsListViewState ->
            with(recyclerComics) {
                adapter = ComicsAdapter(comicsListViewState.comicsList) { idComic ->
                    viewModel.navigateToDetailsComicActivity(idComic)
                }
                layoutManager = LinearLayoutManager(this@ComicsActivity)
            }
        })
    }

    private fun handleAction() {
        viewModel.comicsAction.observe(this, Observer { action ->
            when (action) {
                is ComicsAction.NavigateToDetailsComicActivity -> startDetailsComic(action.idComic)
            }
        })
    }

    private fun startDetailsComic(idComic: Int) {
        val intent = DetailsComicActivity.newInstance(this, idComic)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        handleState()
        handleAction()
    }
}
