package com.example.jetfrutify.data.response.authresponse

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("MESSAGE")
	val mESSAGE: String? = null,

	@field:SerializedName("STATUS")
	val sTATUS: String? = null,

	@field:SerializedName("SENDER")
	val sENDER: String? = null,

	@field:SerializedName("PAYLOAD")
	val pAYLOAD: Any? = null
)
