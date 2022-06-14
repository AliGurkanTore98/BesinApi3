package com.codingurkan.besinapi3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.codingurkan.besinapi3.R
import com.codingurkan.besinapi3.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toFoodFragment.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val email = binding.etEmail.text.toString()
            val age = binding.etAge.text.toString()
            val cellPhone = binding.etCellPhone.text.toString()

            if (name.isNullOrBlank() || surname.isNullOrBlank() || email.isNullOrBlank() || age.isNullOrBlank() || cellPhone.isNullOrBlank()){
                Toast.makeText(requireContext(), "Tüm alanları doldurunuz", Toast.LENGTH_SHORT).show()
            }else{
                val action = LoginFragmentDirections.actionLoginFragmentToFoodFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }


}