package com.example.bottomnavigationview_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationview_fragment.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private lateinit var binding : FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            btnCart.setOnClickListener {
                val action = OrderFragmentDirections.actionOrderFragmentToCheckoutFragment()
                findNavController().navigate(action)
            }
        }
    }
}