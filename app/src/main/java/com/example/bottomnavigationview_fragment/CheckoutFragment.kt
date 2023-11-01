package com.example.bottomnavigationview_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationview_fragment.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment() {
    private lateinit var binding: FragmentCheckoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            val ticketOrder = resources.getStringArray(R.array.orderTicket)
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                ticketOrder
            )

            val hint = "Pilih tiket"
            val hintList = ticketOrder.toMutableList()
            hintList.add(0, hint)
            val hintAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                hintList
            )

            spinnerTkt.adapter = hintAdapter

            spinnerTkt.setSelection(0)

            btnBuy.setOnClickListener {
                if (spinnerTkt.selectedItemPosition != 0) {
                    val action = CheckoutFragmentDirections.actionCheckoutFragmentToTicketTypeFragment()

                    findNavController().navigate(action)
                } else {
                    val errorMessage = "Silakan pilih tiket sebelum melanjutkan."
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}