package com.example.mysimplegame.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mysimplegame.R
import com.example.mysimplegame.databinding.FragmentStartBinding
import com.example.mysimplegame.services.BackgroundSoundService
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class StartFragment : DaggerFragment() {

    //binding
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var backgroundSoundService: BackgroundSoundService


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_gameFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}