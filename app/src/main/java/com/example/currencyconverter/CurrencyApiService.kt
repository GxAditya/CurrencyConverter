package com.example.currencyconverter


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    @GET("v6/{apiKey}/pair/{base}/{target}")
    fun getConversionRate(
        @Path("apiKey") apiKey: String,
        @Path("base") base: String,
        @Path("target") target: String
    ): Call<ConversionResponse>
}
