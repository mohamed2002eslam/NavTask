package com.example.navtask

import kotlinx.serialization.Serializable

@Serializable
data class MessageData(
    val message: String?=null
) : java.io.Serializable
