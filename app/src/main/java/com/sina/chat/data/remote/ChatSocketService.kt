package com.sina.chat.data.remote

import com.sina.chat.domain.model.Message
import com.sina.chat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "base url"
    }

    sealed class Endpoint(val url: String) {
        data object ChatSocket : Endpoint("$BASE_URL/chat-socket")
    }
}