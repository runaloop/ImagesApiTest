package com.catp.imagesapitestapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.catp.imagesapitestapp.databinding.FragmentHomeBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import com.catp.imagesapitestapp.ui.home.PhotosAdapter
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Provider

open class BaseListFragment<T> @Inject constructor(
    private val viewModelProvider: Provider<T>,
    private val adapter: PhotosAdapter
) : Fragment() {


    //protected val viewModel: T by viewModelWithProvider { viewModelProvider.get() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelProvider.get()
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
        })
        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = adapter
        }

        viewModel.items.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }*/
        return binding.root
    }
}
