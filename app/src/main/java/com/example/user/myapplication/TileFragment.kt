package com.example.user.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.user.myapplication.databinding.FragmentTileBinding

class TileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTileBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_tile,
            container,
            false
        )

        binding.playGameButton.setOnClickListener{
            findNavController().navigate(TileFragmentDirections.actionTileToGame())
        }

        return binding.root
    }
}