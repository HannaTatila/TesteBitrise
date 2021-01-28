package com.example.testebitrise.presentation

sealed class ComicsAction {
    class NavigateToDetailsComicActivity(val idComic: Int) : ComicsAction()
}
