package com.sina.chat.presentation.chat

import com.sina.chat.domain.model.Message

data class ChatState(
    val message: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
