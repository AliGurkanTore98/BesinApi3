package com.codingurkan.besinapi3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingurkan.besinapi3.R
import com.codingurkan.besinapi3.adapter.FoodAdapter
import com.codingurkan.besinapi3.databinding.FragmentFoodBinding
import com.codingurkan.besinapi3.model.FoodDataItem
import com.codingurkan.besinapi3.util.showMessage
import com.codingurkan.besinapi3.viewmodel.FoodFragmentViewModel


class FoodFragment : Fragment() {

    private var binding : FragmentFoodBinding? = null
    private var viewModel : FoodFragmentViewModel? = null
    private var adapter : FoodAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(layoutInflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initObservers()
        viewModel?.downloadFoodData()
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[FoodFragmentViewModel::class.java]
    }
    private fun initAdapter(data : ArrayList<FoodDataItem>){
        adapter = FoodAdapter(data , object : FoodAdapter.ItemClickListener{
            override fun clickText(text: String) {
                showMessage(requireContext(),text)
            }
        })
        binding?.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)
        }
    }
    private fun initObservers(){
        viewModel?.food?.observe(viewLifecycleOwner){
            initAdapter(it)
        }
    }

}