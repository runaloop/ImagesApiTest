package com.catp.imagesapitestapp.ui.settings

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.catp.imagesapitestapp.databinding.FragmentSettingsBinding
import com.catp.imagesapitestapp.di.viewModelWithProvider
import javax.inject.Inject
import javax.inject.Provider


class SettingsFragment @Inject constructor(
    private val viewModelProvider: Provider<SettingsViewModel>,
    private val switchNightMode: SwitchNightMode

) : Fragment() {

    private val settingsViewModel by viewModelWithProvider { viewModelProvider.get() }

    //TODO: Как правильно хранить стейт при переключении темы? Если делать по феншую -
    // через ViewModel то при пересоздании активити ViewModel останется жив, и все
    // зависимости(интеракторы) остануться закешированными от прошлого пересоздания потому что ViewModel
    // сохраниться изза смены конфигурации, или делать не по феншую, и хранить эту инфу внутри фрагмента?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.nightModeSwitch.isChecked = isNightModeActive()
        binding.viewModel = settingsViewModel
        binding.switchNightMode = switchNightMode

        return binding.root
    }

    private fun isNightModeActive(): Boolean =
        resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

}
