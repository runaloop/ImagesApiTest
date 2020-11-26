package com.catp.imagesapitestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.catp.imagesapitestapp.databinding.FragmentHomeBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment @Inject constructor(
    private val viewModelProvider: Provider<HomeViewModel>,
    private val adapter: PhotosAdapter
) : Fragment() {

    private val homeViewModel by viewModelWithProvider { viewModelProvider.get() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
        })
        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = adapter
        }

        homeViewModel.items.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
