package com.example.androidmugbootcampodev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidmugbootcampodev5.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private var input = ""
    private var firstNumber: Int? = null
    private var isAddition = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCalculatorBinding.inflate(inflater,container,false)
        val numberButtons = listOf(
            binding.button0, binding.button1, binding.button2,
            binding.button3, binding.button4, binding.button5,
            binding.button6, binding.button7, binding.button8, binding.button9
        )
        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                input += index.toString()
                binding.textViewResult.text = input
            }
        }
        binding.buttonPlus.setOnClickListener {
            firstNumber = input.toIntOrNull()
            input = ""
            isAddition = true
            binding.textViewResult.text = "0"        }
        binding.buttonResult.setOnClickListener {
            if (isAddition && firstNumber != null) {
                val secondNumber = input.toIntOrNull()
                if (secondNumber != null) {
                    val result = firstNumber!! + secondNumber
                    binding.textViewResult.text = result.toString()
                    input = ""
                    firstNumber = null
                    isAddition = false
                } else {
                    binding.textViewResult.text = "Hatalı giriş"
                }
            }
        }
        return binding.root
    }

}