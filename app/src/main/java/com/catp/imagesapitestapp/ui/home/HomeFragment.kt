package com.catp.imagesapitestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.catp.imagesapitestapp.R
import com.catp.imagesapitestapp.di.viewModelWithProvider
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment @Inject constructor(
    private val viewModelProvider: Provider<HomeViewModel>
) : Fragment() {

    private val homeViewModel by viewModelWithProvider { viewModelProvider.get() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}