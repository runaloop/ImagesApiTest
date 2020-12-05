package com.catp.imagesapitestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.catp.imagesapitestapp.MyRoom
import com.catp.imagesapitestapp.databinding.FragmentHomeBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import com.catp.imagesapitestapp.ui.base.BaseListFragment
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment @Inject constructor(
    private val viewModelProvider: Provider<HomeViewModel>,
    private val adapter: PhotosAdapter,
    private val myRoom: MyRoom
) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
