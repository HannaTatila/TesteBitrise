package com.example.testebitrise.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testebitrise.domain.usecase.GetComicByIdUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailsComicViewModel(
    private val detailsComicUseCase: GetComicByIdUseCase
) : ViewModel() {

    private val comicMutableLiveData: MutableLiveData<ComicViewState> = MutableLiveData()
    val comicViewState: LiveData<ComicViewState> = comicMutableLiveData
    private val compositeDisposable = CompositeDisposable()

    fun getComicById(idComic: Int) {
        detailsComicUseCase(idComic).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
//            .doOnSubscribe { showLoading() }
//            .doFinally { hideLoading() }
            .subscribe({
                it?.let { comic ->
                    comicMutableLiveData.postValue(ComicViewState(false, comic))
                }
            }, { error ->
                error.printStackTrace()
            })
            .apply { compositeDisposable.add(this) }
    }

    private fun hideLoading() {
        comicMutableLiveData.postValue(ComicViewState(isLoading = false))
    }

    private fun showLoading() {
        comicMutableLiveData.postValue(ComicViewState(isLoading = true))
    }
}
