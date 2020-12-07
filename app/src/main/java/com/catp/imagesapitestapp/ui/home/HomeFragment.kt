package com.catp.imagesapitestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catp.imagesapitestapp.databinding.FragmentHomeBinding
import com.catp.imagesapitestapp.ui.base.BaseListFragment
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment @Inject constructor(
    viewModelProvider: Provider<HomeViewModel>,
    adapter: PhotosAdapter,
) : BaseListFragment<HomeViewModel>(viewModelProvider, adapter) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecycler(binding.recyclerView)
        return binding.root
    }
}
