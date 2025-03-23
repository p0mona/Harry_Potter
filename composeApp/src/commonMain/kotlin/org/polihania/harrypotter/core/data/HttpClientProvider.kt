package org.polihania.harrypotter.core.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface HttpClientProvider {
    fun getClient(): HttpClient
}

class HttpClientProviderImpl : HttpClientProvider {
    override fun getClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }

            install(DefaultRequest) {
                url(BASE_URL)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }
}

private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/en/"
