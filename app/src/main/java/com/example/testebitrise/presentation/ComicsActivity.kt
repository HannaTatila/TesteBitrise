package com.example.testebitrise.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testebitrise.R
import com.example.testebitrise.di.ComicsModule
import com.google.android.material.snackbar.Snackbar
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
        viewModel.comicsViewState.observe(this, { comicsListViewState ->
            with(recyclerComics) {
                adapter = ComicsAdapter(comicsListViewState.comicsList) {}
                layoutManager = LinearLayoutManager(this@ComicsActivity)
            }
        })
    }

    private fun handleAction() {
        viewModel.comicsAction?.observe(this, { action ->
            when (action) {
                is ComicsAction.ShowSnackBar -> showSnackbar(action.message)
                is ComicsAction.NavigateToDetailsComicActivity -> null //startDetailsComic(action.idComic)
            }
        })
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(recyclerComics, message, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onResume() {
        super.onResume()
        handleState()
        handleAction()
    }
}
