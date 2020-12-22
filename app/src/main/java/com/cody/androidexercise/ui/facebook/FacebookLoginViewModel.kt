package com.cody.androidexercise.ui.facebook

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.cody.androidexercise.credential.CredentialRepository
import com.facebook.*
import com.facebook.login.*
import com.google.gson.Gson

class FacebookLoginViewModel : ViewModel() {
    private lateinit var callbackManager: CallbackManager

    fun initLoginCallback() {
        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    val accessToken = result?.accessToken
                    if (accessToken != null && !accessToken.isExpired) {
                        CredentialRepository.facebookToken = Gson().toJson(accessToken)
                    }
                }

                override fun onCancel() {}

                override fun onError(error: FacebookException?) {}
            }
        )
    }

    fun onLoginResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}