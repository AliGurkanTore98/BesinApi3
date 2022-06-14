package com.codingurkan.besinapi3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingurkan.besinapi3.model.FoodDataItem
import com.codingurkan.besinapi3.service.ApiClient
import com.codingurkan.besinapi3.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FoodFragmentViewModel : ViewModel() {
    private var job : Job? = null
    val food =MutableLiveData<ArrayList<FoodDataItem>>()
    private val apiClient = ApiClient.getClient().create(ApiService::class.java)

    fun downloadFoodData(){

        job =viewModelScope.launch(Dispatchers.IO){
            val response = apiClient.getData()

            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        food.value = it
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}