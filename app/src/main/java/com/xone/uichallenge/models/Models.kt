package com.xone.uichallenge.models

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Photo(val id: String, val urls: Urls, val width: Int, val height: Int)

@Serializable
data class Urls(val regular: String)