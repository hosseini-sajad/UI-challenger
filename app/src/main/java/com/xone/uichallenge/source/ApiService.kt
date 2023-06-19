package com.xone.uichallenge.source

import com.xone.uichallenge.models.ModelClass
import com.xone.uichallenge.models.Photo
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: Client-ID yg_jjZvIwUJReA2ARHDB0ZaCbUAJyPjCu76MMDApD2I")
    @GET("photos?order_by=popular&orientation=squarish&per_page=40")
    suspend fun getPhotos(): ModelClass
}