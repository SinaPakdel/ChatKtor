package com.sina.chat.data.remote

import com.sina.chat.data.remote.dto.MessageDto
import com.sina.chat.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MessageServiceImpl(private val client: HttpClient) : MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(
                MessageService.Endpoint.GetAllMessages.url
            ).map {
                it.toMessage()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}