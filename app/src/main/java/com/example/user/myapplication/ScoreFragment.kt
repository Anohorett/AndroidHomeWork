package com.example.user.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.user.myapplication.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentScoreBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_score,
            container,
            false
        )

        return binding.root
    }
}