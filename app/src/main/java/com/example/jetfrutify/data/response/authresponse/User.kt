package com.example.jetfrutify.data.response.authresponse

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("USER_PHONE")
    val uSERPHONE: String? = null,

    @field:SerializedName("USER_PASSWORD")
    val uSERPASSWORD: String? = null,

    @field:SerializedName("USER_TOKEN")
    val uSERTOKEN: String? = null,

    @field:SerializedName("USER_EMAIL")
    val uSEREMAIL: String? = null,

    @field:SerializedName("USER_ID")
    val uSERID: Int? = null,

    @field:SerializedName("USER_TOKEN_EXPIRED")
    val uSERTOKENEXPIRED: String? = null,

    @field:SerializedName("USER_ADDRESS")
    val uSERADDRESS: String? = null,

    @field:SerializedName("USER_ROLE")
    val uSERROLE: String? = null,

    @field:SerializedName("USER_FULLNAME")
    val uSERFULLNAME: String? = null
)