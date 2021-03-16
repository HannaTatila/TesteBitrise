package com.example.testebitrise.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testebitrise.domain.model.Characters
import com.example.testebitrise.domain.model.Comic
import com.example.testebitrise.domain.usecase.GetCharactersUseCase
import com.example.testebitrise.domain.usecase.GetComicByIdUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailsComicViewModel(
    private val detailsComicUseCase: GetComicByIdUseCase,
    private val characterUseCase: GetCharactersUseCase
) : ViewModel() {

    private val comicMutableLiveData: MutableLiveData<ComicViewState> = MutableLiveData()
    val comicViewState: LiveData<ComicViewState> = comicMutableLiveData
    private val compositeDisposable = CompositeDisposable()

    fun getComicById(idComic: Int) {
        Single.concat(getComic(idComic), getCharacters(idComic))
            .doOnSubscribe {
                showLoading()
            }
            .doOnTerminate { hideLoading() }
            .subscribe { }
            .apply { compositeDisposable.add(this) }
    }

    private fun getComic(idComic: Int): Single<Comic> {
        return detailsComicUseCase(idComic)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                it?.let { comic ->
                    comicMutableLiveData.value = comicMutableLiveData.value?.copy(comic = comic)
                }
            }
            .doOnError { error -> error.printStackTrace() }
    }

    private fun getCharacters(idComic: Int): Single<List<Characters>> {
        return characterUseCase(idComic)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                it?.let { characterList ->
                    comicMutableLiveData.value = comicMutableLiveData.value?.copy(characters = characterList)
                }
            }
            .doOnError { error -> error.printStackTrace() }
    }

    private fun showLoading() {
        comicMutableLiveData.value = ComicViewState(isLoading = true)
    }

    private fun hideLoading() {
        comicMutableLiveData.value = comicMutableLiveData.value?.copy(isLoading = false)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
