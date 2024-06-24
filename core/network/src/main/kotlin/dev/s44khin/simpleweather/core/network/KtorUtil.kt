package dev.s44khin.simpleweather.core.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get

suspend inline fun <reified T> HttpClient.getBody(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
) = get(
    urlString = urlString,
    block = block,
).body<T>()
