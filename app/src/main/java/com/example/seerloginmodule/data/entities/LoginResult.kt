package com.example.seerloginmodule.data.entities

data class LoginResult(
    val success: User? = null,
    val error: Int? = null
)