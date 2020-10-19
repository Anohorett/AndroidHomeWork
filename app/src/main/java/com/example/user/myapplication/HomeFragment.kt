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

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_home, container, false)
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

        /*view.findViewById<Button>(R.id.button1).setOnClickListener {
            findNavController().navigate(R.id.secondFragment, null, options)
        }

        view.findViewById<Button>(R.id.button_with_action)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )*/

    }
}