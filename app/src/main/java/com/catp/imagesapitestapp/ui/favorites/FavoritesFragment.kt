package com.catp.imagesapitestapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catp.imagesapitestapp.databinding.FragmentFavoritesBinding
import com.catp.imagesapitestapp.ui.base.BaseListFragment
import com.catp.imagesapitestapp.ui.home.PhotosAdapter
import javax.inject.Inject
import javax.inject.Provider

class FavoritesFragment @Inject constructor(
    viewModelProvider: Provider<FavoritesViewModel>,
    adapter: PhotosAdapter
) : BaseListFragment<FavoritesViewModel>(viewModelProvider, adapter) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        initRecycler(binding.recyclerView)

        return binding.root
    }
}