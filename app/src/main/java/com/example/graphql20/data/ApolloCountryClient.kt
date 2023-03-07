package com.example.graphql20.data

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphql20.domain.CountryClient
import com.example.graphql20.domain.DetailedCountry
import com.example.graphql20.domain.SimpleCountry
import com.example.graphql20.toDetailedCountry
import com.example.graphql20.toSimpleCountry

class ApolloCountryClient(
    private val apolloClient : ApolloClient
    ) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {
                it.toSimpleCountry()
            }
            ?: emptyList()
    }
    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}