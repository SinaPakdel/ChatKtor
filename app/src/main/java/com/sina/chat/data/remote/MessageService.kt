package com.sina.chat.data.remote

import com.sina.chat.domain.model.Message

interface MessageService {
    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "base url"
    }

    sealed class Endpoint(val url: String) {
        data object GetAllMessages : Endpoint("$BASE_URL/messages")
    }

}