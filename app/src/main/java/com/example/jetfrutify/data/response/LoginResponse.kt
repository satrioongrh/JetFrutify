package com.example.jetfrutify.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("MESSAGE")
	val mESSAGE: String? = null,

	@field:SerializedName("STATUS")
	val sTATUS: String? = null,

	@field:SerializedName("SENDER")
	val sENDER: String? = null,

	@field:SerializedName("PAYLOAD")
	val pAYLOAD: PAYLOAD? = null
)

data class PAYLOAD(

	@field:SerializedName("user")
	val user: User? = null
)
