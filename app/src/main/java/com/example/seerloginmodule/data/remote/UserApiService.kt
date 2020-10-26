package com.example.seerloginmodule.data.remote

import com.devtides.dogs.model.LoginRequest
import com.example.seerloginmodule.data.entities.LoginResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserApiService {

    private val BASE_URL = "http://cafm.agfacilities.com"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(UserApi::class.java)

    fun validateUser(loginRequest: LoginRequest): Single<LoginResponse> {
        return api.validateUser(loginRequest)
    }

//    fun getUser(): Single<List<DogBreed>> {
//        return api.getUser()
//    }
}