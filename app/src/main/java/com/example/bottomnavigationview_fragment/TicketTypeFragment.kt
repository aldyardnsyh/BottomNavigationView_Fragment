package com.example.bottomnavigationview_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationview_fragment.databinding.FragmentTickettypeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TicketTypeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TicketTypeFragment : Fragment() {

    private lateinit var binding: FragmentTickettypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTickettypeBinding.inflate(layoutInflater, container, false)

        val selectedTicket = arguments?.getString("selectedTicket")
        val ticketType = binding.tvTicket
        ticketType.setText(selectedTicket)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set("selectedTicket", tvTicket.toString())
                }.navigateUp()
            }
        }
    }
}