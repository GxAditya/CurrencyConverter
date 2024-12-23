package com.example.currencyconverter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.ConversionResponse
import com.example.currencyconverter.CurrencyApiService
import com.example.currencyconverter.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var etAmount: EditText
    private lateinit var spinnerBaseCurrency: Spinner
    private lateinit var spinnerTargetCurrency: Spinner
    private lateinit var btnConvert: Button
    private lateinit var tvResult: TextView

    private val apiKey = "3f65a88ffdf0785ab6883bd5"
    private val baseUrl = "https://v6.exchangerate-api.com/"
    private val currencyList = listOf(
        "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
        "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
        "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
        "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP",
        "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS",
        "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
        "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD",
        "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT",
        "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
        "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN",
        "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
        "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
        "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP",
        "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
        "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND",
        "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW",
        "ZWL"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAmount = findViewById(R.id.etAmount)
        spinnerBaseCurrency = findViewById(R.id.spinnerBaseCurrency)
        spinnerTargetCurrency = findViewById(R.id.spinnerTargetCurrency)
        btnConvert = findViewById(R.id.btnConvert)
        tvResult = findViewById(R.id.tvResult)

        setupSpinners()

        btnConvert.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull()
            val baseCurrency = spinnerBaseCurrency.selectedItem.toString()
            val targetCurrency = spinnerTargetCurrency.selectedItem.toString()

            if (amount != null) {
                convertCurrency(amount, baseCurrency, targetCurrency)
            } else {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSpinners() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            currencyList
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerBaseCurrency.adapter = adapter
        spinnerTargetCurrency.adapter = adapter
    }

    private fun convertCurrency(amount: Double, base: String, target: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CurrencyApiService::class.java)
        val call = service.getConversionRate(apiKey, base, target)

        call.enqueue(object : Callback<ConversionResponse> {
            override fun onResponse(
                call: Call<ConversionResponse>,
                response: Response<ConversionResponse>
            ) {
                if (response.isSuccessful) {
                    val conversionRate = response.body()?.conversion_rate
                    if (conversionRate != null) {
                        val convertedAmount = amount * conversionRate
                        tvResult.text = "Converted Amount: $convertedAmount $target"
                    } else {
                        tvResult.text = "Failed to retrieve conversion rate"
                    }
                } else {
                    tvResult.text = "API Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<ConversionResponse>, t: Throwable) {
                tvResult.text = "API Call Failed: ${t.message}"
            }
        })
    }
}
