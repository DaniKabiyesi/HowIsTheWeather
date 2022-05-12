package com.studying.howistheweather.viewmodel.login

import androidx.lifecycle.ViewModel


class LoginViewModel() : ViewModel() {

    fun signValidation(login: String, password: String): ViewState? {
        var response: ViewState? = null
        when {
            login.isNotEmpty() && password.isNotEmpty() -> response = ViewState.SUCCESS
            login.isEmpty() && password.isNotEmpty() -> response = ViewState.ERROR
            login.isNotEmpty() && password.isEmpty() -> response = ViewState.ERROR
        }
        return response
    }

    enum class ViewState {
        SUCCESS,
        ERROR
    }
}

