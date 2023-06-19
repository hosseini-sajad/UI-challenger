package com.xone.uichallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xone.uichallenge.models.ModelClass
import com.xone.uichallenge.models.ModelClass.ModelClassItem
import com.xone.uichallenge.models.Photo
import com.xone.uichallenge.models.PhotoModel
import com.xone.uichallenge.source.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private var counter = 0

    private val mutablePhotoObservable: MutableLiveData<List<PhotoModel>> by lazy {
        MutableLiveData<List<PhotoModel>>()
    }
    val photoObservable: LiveData<List<PhotoModel>> get() = mutablePhotoObservable

    fun getPhotos() {
        viewModelScope.launch {
            mutablePhotoObservable.value = fetchPhotos()
        }
    }

    private suspend fun fetchPhotos(): List<PhotoModel> = withContext(Dispatchers.IO) {
        counter = 0

        val response: List<PhotoModel>
        try {
            val photos = arrayListOf<PhotoModel>()
            val x = apiService.getPhotos().chunked(3)
                x.map {
                    val photo = when (counter % 4) {
                        0 -> PhotoModel(it[0].urls.regular, it[1].urls.regular, it[2].urls.regular, viewType = 0)
                        1 -> PhotoModel(it[0].urls.regular, it[1].urls.regular, it[2].urls.regular, viewType = 1)
                        2 -> PhotoModel(it[0].urls.regular, it[1].urls.regular, it[2].urls.regular, viewType = 2)
                        3 -> PhotoModel(it[0].urls.regular, it[1].urls.regular, it[2].urls.regular, viewType = 3)
                        else -> PhotoModel(it[0].urls.regular, it[1].urls.regular, it[2].urls.regular, viewType = 0)
                    }

                photos.add(photo)
                    counter++
                }
            return@withContext photos
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return@withContext listOf<PhotoModel>()
    }
}
