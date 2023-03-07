package com.example.graphql20.domain


interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>
    suspend fun getCountry(code : String) : DetailedCountry?

}
