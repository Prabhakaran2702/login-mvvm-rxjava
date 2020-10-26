package com.example.seerloginmodule.ui.main.viewmodel


import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devtides.dogs.model.LoginRequest
import com.example.seerloginmodule.R
import com.example.seerloginmodule.data.entities.*
import com.example.seerloginmodule.data.repository.LoginFormState
import com.example.seerloginmodule.data.remote.UserApiService
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers



class LoginViewModel(application: Application) : BaseViewModel(application) {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val userService = UserApiService()
    private val disposable = CompositeDisposable()

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult


    private fun fetchFromRemote(username: String, password: String) {

//        disposable.add(
//            userService.getUser()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object: DisposableSingleObserver<List<DogBreed>>() {
//
//                    override fun onSuccess(response: List<DogBreed>) {
//
//                        Log.d("res", response.toString())
//
//                    }
//
//                    override fun onError(e: Throwable) {
//                        e.printStackTrace()
//                    }
//
//                })
//        )
    }

    private fun loginRemote(username: String, password: String) {

        disposable.add(
            userService.validateUser(LoginRequest(username,password))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<LoginResponse>() {

                    override fun onSuccess(response: LoginResponse) {

                        Log.d("res", Gson().toJson(response))

              if (response.mStatus=="True") {
            _loginResult.value = LoginResult(success = response.mUser)
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
                    }
                    override fun onError(e: Throwable) {
                        _loginResult.value = LoginResult(error = R.string.login_failed)
                        e.printStackTrace()
                    }

                })
        )
    }



    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        loginRemote(username,password)
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.isNotBlank()) {
          //  Patterns.EMAIL_ADDRESS.matcher(username).matches()
            return username.length > 5
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}