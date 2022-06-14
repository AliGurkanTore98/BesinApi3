package com.codingurkan.besinapi3.service

import com.codingurkan.besinapi3.model.FoodDataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    suspend fun getData() : Response<ArrayList<FoodDataItem>>
}