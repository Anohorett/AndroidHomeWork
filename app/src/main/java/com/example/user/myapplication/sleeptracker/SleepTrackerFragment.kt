package com.example.user.myapplication.sleeptracker

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
import com.example.user.myapplication.databinding.SleepTrackerFragmentBinding
import com.google.android.material.snackbar.Snackbar

class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepTrackerFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.sleep_tracker_fragment, container, false)
        val application = requireNotNull(this.activity).application

        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory = SleepTrackerViewModelFactory(dataSource, application)

        val sleepTrackerViewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(SleepTrackerViewModel::class.java)

        binding.lifecycleOwner = this
        binding.sleepTrackerViewModel = sleepTrackerViewModel

        sleepTrackerViewModel.navigateToSleepQuality.observe(viewLifecycleOwner, { night ->
            night?.let {
                this.findNavController().navigate(
                    SleepTrackerFragmentDirections
                        .actionSleepTrackerFragmentToSleepQualityFragment(night.nightId)
                )
                sleepTrackerViewModel.doneNavigating()
            }
        })

        sleepTrackerViewModel.showSnackBarEvent.observe(viewLifecycleOwner, {
            if (it == true) {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    getString(R.string.clear),
                    Snackbar.LENGTH_SHORT
                ).show()
                sleepTrackerViewModel.doneShowingSnackBar()
            }
        })

        return binding.root
    }
}