package com.example.seerloginmodule.data.remote

import com.devtides.dogs.model.LoginRequest
import com.example.seerloginmodule.data.entities.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("mobileapi/webapi/login/validateUser")
    fun validateUser(@Body loginRequest: LoginRequest?): Single<LoginResponse>

//    @GET("DevTides/DogsApi/master/dogs.json")
//    fun getUser(): Single<List<DogBreed>>



}