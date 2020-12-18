package com.catp.imagesapitestapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.catp.imagesapitestapp.R
import com.catp.imagesapitestapp.databinding.FragmentDetailBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import javax.inject.Inject
import javax.inject.Provider

open class DetailFragment @Inject constructor(private val viewModelProvider: Provider<DetailViewModel>) :
    Fragment() {

    protected val viewModel by viewModelWithProvider { viewModelProvider.get() as DetailViewModel }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val action = DetailFragmentArgs.fromBundle(requireArguments())
        binding.photo = action.photo
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = TransitionInflater.from(this.context).inflateTransition(R.transition.change_bounds)
        sharedElementReturnTransition =  TransitionInflater.from(this.context).inflateTransition(R.transition.change_bounds)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
