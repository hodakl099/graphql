package com.example.graphql20.domain

import com.example.CountriesQuery
import com.example.CountryQuery

interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>
    suspend fun getCountry(code : String) : DetailedCountry?
}