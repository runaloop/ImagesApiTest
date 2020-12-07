package com.catp.imagesapitestapp.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.catp.imagesapitestapp.di.viewModelWithProvider
import com.catp.imagesapitestapp.ui.home.PhotosAdapter
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Provider

open class BaseListFragment<out T : BaseListViewModel> @Inject constructor(
    private val viewModelProvider: Provider<T>,
    private val adapter: PhotosAdapter
) : Fragment() {
    protected val viewModel by viewModelWithProvider { viewModelProvider.get() as BaseListViewModel }

    fun initRecycler(recyclerView: RecyclerView) {
        viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Snackbar.make(recyclerView.rootView, it, Snackbar.LENGTH_LONG)
        })
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = adapter
        }

        viewModel.items.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}
