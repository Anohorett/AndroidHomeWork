package com.example.user.myapplication.sleepquality

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.user.myapplication.R
import com.example.user.myapplication.database.SleepDatabase
import com.example.user.myapplication.databinding.SleepQualityFragmentBinding

class SleepQualityFragment : Fragment() {

    companion object {
        fun newInstance() = SleepQualityFragment()
    }

    private lateinit var viewModel: SleepQualityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepQualityFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.sleep_quality_fragment, container, false
        )

        val application = requireNotNull(this.activity).application

        val arguments = SleepQualityFragmentArgs.fromBundle(arguments!!)
        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory = SleepQualityModelFactory(arguments.sleepNightKey, dataSource)

        val sleepQualityViewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(
            SleepQualityViewModel::class.java
        )

        binding.sleepQualityViewModel = sleepQualityViewModel

        sleepQualityViewModel.navigateToSleepTracker.observe(this, {
            if (it == true) {
                this.findNavController().navigate(
                    SleepQualityFragmentDirections.actionSleepQualityFragmentToSleepTrackerFragment()
                )
                sleepQualityViewModel.doneNavigating()
            }
        })

        return binding.root
    }

}