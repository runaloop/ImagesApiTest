package com.catp.imagesapitestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.catp.imagesapitestapp.R
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
        viewModel.navigateToDetailScreen.observe(viewLifecycleOwner) {
            it?.let { photo ->
                viewModel.navigateToDetailDone()
                val imageView = binding.recyclerView.findViewById<ImageView>(R.id.imageView)
                val actionHomeToDetailFragment =
                    HomeFragmentDirections.actionNavigationHomeToDetailFragment(photo)
                val extras = FragmentNavigatorExtras(imageView to photo.id)
                findNavController()
                    .navigate(actionHomeToDetailFragment, extras)
            }
        }
        return binding.root
    }
}
