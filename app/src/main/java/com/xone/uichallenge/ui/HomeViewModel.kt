package com.xone.uichallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xone.uichallenge.models.ModelClass
import com.xone.uichallenge.models.ModelClass.ModelClassItem
import com.xone.uichallenge.models.Photo
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

    private val mutablePhotoObservable: MutableLiveData<List<List<ModelClassItem>>> by lazy {
        MutableLiveData<List<List<ModelClassItem>>>()
    }
    val photoObservable: LiveData<List<List<ModelClassItem>>> get() = mutablePhotoObservable

    fun getPhotos() {
        viewModelScope.launch {
            mutablePhotoObservable.value = fetchPhotos()
        }
    }

    private suspend fun fetchPhotos(): List<List<ModelClassItem>> = withContext(Dispatchers.IO) {
        counter = 0

        val response: List<List<ModelClassItem>>
        try {
            response = apiService.getPhotos().chunked(3).onEach { modelClassItems ->
                modelClassItems.onEach { modelClass ->
                    when (counter % 4) {
                        0 -> modelClass.viewType = 0
                        1 -> modelClass.viewType = 1
                        2 -> modelClass.viewType = 2
                        3 -> modelClass.viewType = 3
                    }
                }
                counter++
            }
            return@withContext response
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return@withContext listOf<List<ModelClassItem>>()
    }
}
