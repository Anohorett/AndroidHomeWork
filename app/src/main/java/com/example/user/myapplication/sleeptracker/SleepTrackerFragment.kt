package com.example.user.myapplication.sleeptracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.user.myapplication.R
import com.example.user.myapplication.databinding.SleepTrackerFragmentBinding

class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepTrackerFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.sleep_tracker_fragment, container, false)

        return binding.root
    }
}