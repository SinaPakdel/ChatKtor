package com.sina.chat.presentation.username

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsernameViewModel @Inject constructor() : ViewModel() {


    private val _uusernameText = mutableStateOf("")
    val usernameText: State<String> = _uusernameText


    private val _onJoingChat = MutableSharedFlow<String>()
    val onJoinFChat = _onJoingChat.asSharedFlow()


    fun onUsernameChange(username: String) {
        _uusernameText.value = username
    }

    fun onJoinClick() {
        viewModelScope.launch {
            if (usernameText.value.isNotBlank()) {
                _onJoingChat.emit(usernameText.value)
            }
        }
    }
}