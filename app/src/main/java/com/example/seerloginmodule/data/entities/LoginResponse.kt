package com.example.seerloginmodule.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class LoginResponse(

    @SerializedName("message")
     var mMessage: String? = null,
    @SerializedName("object")
     val mUser: User? = null,

    @SerializedName("status")
     val mStatus: String? = null,

    @SerializedName("totalNumberOfRows")
     val totalNumberOfRows: String? = null


)

@Parcelize
class User(
    @SerializedName("createdUser")
     var mCreatedUser: String? = null,
    @SerializedName("creationDate")
 val mCreationDate: String? = null,

@SerializedName("emailId")
 val mEmailId: String? = null,

@SerializedName("employeeId")
 val mEmployeeId: String? = null,

@SerializedName("firstName")
 val mFirstName: String? = null,

@SerializedName("lastName")
 val mLastName: String? = null,

@SerializedName("mobileNumber")
private val mMobileNumber: String? = null,

@SerializedName("password")
 val mPassword: String? = null,

@SerializedName("phoneNumber")
 val mPhoneNumber: String? = null,

@SerializedName("status")
 val mStatus: String? = null,

@SerializedName("userName")
 val mUserName: String? = null,

@SerializedName("userType")
 val mUserType: String? = null,

@SerializedName("customerCode")
 val customerCode: String? = null,

@SerializedName("contractNo")
 val contractNo: String? = null,

@SerializedName("trackingFlag")
 var trackingFlag: String? = null) : Parcelable
