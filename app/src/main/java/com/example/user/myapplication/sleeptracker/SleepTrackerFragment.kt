package com.example.user.myapplication.sleeptracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.user.myapplication.R
import com.example.user.myapplication.database.SleepDatabase
import com.example.user.myapplication.databinding.SleepTrackerFragmentBinding

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

        binding.setLifecycleOwner(this)
        binding.sleepTrackerViewModel = sleepTrackerViewModel

        return binding.root
    }
}