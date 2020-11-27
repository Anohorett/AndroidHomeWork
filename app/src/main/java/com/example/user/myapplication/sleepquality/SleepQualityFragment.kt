package com.example.user.myapplication.sleepquality

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.user.myapplication.R
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

        return binding.root
    }

}