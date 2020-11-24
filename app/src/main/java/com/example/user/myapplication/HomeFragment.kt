package com.example.user.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.user.myapplication.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : Fragment(), LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun log() {
        Timber.i("\tOnLifecycleEvent")
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        Timber.i("\tonCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("\tonViewCreated")

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
        Timber.i("\tonDestroyView")
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("\tonAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("\tonCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("\tonStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("\tonResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("\tonPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("\tonStop")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("\tonDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Timber.i("onSaveInstanceState")
    }
}