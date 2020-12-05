package com.catp.imagesapitestapp.ui.home

import com.catp.imagesapitestapp.data.Repo
import com.catp.imagesapitestapp.ui.base.BaseListViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    repo: Repo,
    cs: CompositeDisposable
) : BaseListViewModel(repo, cs)