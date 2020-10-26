package com.example.seerloginmodule.data.repository

import com.devtides.dogs.model.LoginRequest
import com.example.seerloginmodule.data.entities.LoginResponse

interface LoginRepository {

    suspend fun loginValidation(loginRequest: LoginRequest) : LoginResponse

}