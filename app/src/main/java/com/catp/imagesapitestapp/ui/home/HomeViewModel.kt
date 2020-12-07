package com.catp.imagesapitestapp.ui.home

import androidx.lifecycle.MutableLiveData
import com.catp.imagesapitestapp.data.Repo
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.ui.base.BaseListViewModel
import com.catp.imagesapitestapp.util.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    repo: Repo,
    cs: CompositeDisposable,
    errorText: SingleLiveEvent<String>,
    loading: MutableLiveData<Boolean>,
    items: MutableLiveData<List<Photo>>
) : BaseListViewModel(repo, cs, errorText, loading, items)