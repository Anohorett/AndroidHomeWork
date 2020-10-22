package com.example.user.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.user.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.fragment_open_enter
                exit = R.anim.fragment_fade_exit
                popEnter = R.anim.fragment_fade_enter
                popExit = R.anim.fragment_close_exit

            }
        }

        binding.navigateActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )

        binding.navigateDestinationButton.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}