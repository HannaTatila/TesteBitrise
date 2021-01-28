package com.example.testebitrise.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testebitrise.core.SingleLiveEvent
import com.example.testebitrise.domain.usecase.GetComicUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListComicsViewModel(
    private val comicsUseCase: GetComicUseCase
) : ViewModel() {

    private val comicsListMutableLiveData: MutableLiveData<ComicsViewState> = MutableLiveData()
    val comicsViewState: LiveData<ComicsViewState> = comicsListMutableLiveData

    private val comicsActionSingleLive = SingleLiveEvent<ComicsAction>()
    val comicsAction: LiveData<ComicsAction> = comicsActionSingleLive

    private val compositeDisposable = CompositeDisposable()

    init {
        getComicsList()
    }

    fun getComicsList() {
        comicsUseCase().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { comicList ->
                    comicsListMutableLiveData.postValue(
                        ComicsViewState(
                            false,
                            comicsList = comicList
                        )
                    )
                }
            }, { error ->
                error.printStackTrace()
            })
            .apply { compositeDisposable.add(this) }
    }

    fun navigateToDetailsComicActivity(idComic: Int) {
        comicsActionSingleLive.postValue(ComicsAction.NavigateToDetailsComicActivity(idComic))
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
