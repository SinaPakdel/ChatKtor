package com.sina.chat.di

import com.sina.chat.data.remote.ChatSocketService
import com.sina.chat.data.remote.ChatSocketServiceImpl
import com.sina.chat.data.remote.MessageService
import com.sina.chat.data.remote.MessageServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.WebSockets
import kotlinx.serialization.KSerializer
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }

    }


    fun provideMessageService(client: HttpClient): MessageService {
        return MessageServiceImpl(client)
    }

    fun provideChatScokerService(client: HttpClient): ChatSocketService {
        return ChatSocketServiceImpl(client)
    }
}