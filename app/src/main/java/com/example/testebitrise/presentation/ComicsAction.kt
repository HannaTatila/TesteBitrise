package com.example.testebitrise.presentation

sealed class ComicsAction {
    class ShowSnackBar(val message: String) : ComicsAction()
    class NavigateToDetailsComicActivity(val idComic: Int) : ComicsAction()
}
