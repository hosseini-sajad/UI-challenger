package com.xone.uichallenge.api

import com.xone.uichallenge.models.ModelClass
import com.xone.uichallenge.models.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

//suspend fun fetchPhotos(): List<ModelClass.ModelClassItem> = withContext(Dispatchers.IO){
//    val client = OkHttpClient()
//
//    val request = Request.Builder()
//        .url("https://api.unsplash.com/photos?order_by=popular&orientation=squarish&per_page=40")
//        .addHeader("Authorization", "Client-ID yg_jjZvIwUJReA2ARHDB0ZaCbUAJyPjCu76MMDApD2I")
//        .build()
//
//    client.newCall(request).execute().use { response ->
//        if (!response.isSuccessful) throw IllegalStateException("Unexpected code $response")
//
//        val body = response.body?.string()
//        val photos: List<ModelClass.ModelClassItem> = Json{
//            ignoreUnknownKeys = true
//        }.decodeFromString(body ?: "")
//
//        return@use photos
//    }
//}