package com.sina.chat.domain.model

import java.sql.Timestamp
import java.text.DateFormat
import java.util.Date

data class Message(
    val text: String,
    val formatedTime: String,
    val username: String,
)