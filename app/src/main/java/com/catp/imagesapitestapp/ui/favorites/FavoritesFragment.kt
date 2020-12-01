package com.catp.imagesapitestapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.catp.imagesapitestapp.databinding.FragmentFavoritesBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import com.catp.imagesapitestapp.ui.home.PhotosAdapter
import javax.inject.Inject
import javax.inject.Provider

class FavoritesFragment @Inject constructor(
    private val viewModelProvider: Provider<FavoritesViewModel>,
    private val adapter: PhotosAdapter
) : Fragment() {

    private val favoritesViewModel: FavoritesViewModel by viewModelWithProvider { viewModelProvider.get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = adapter
        }
        favoritesViewModel.items.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        return binding.root
    }
}