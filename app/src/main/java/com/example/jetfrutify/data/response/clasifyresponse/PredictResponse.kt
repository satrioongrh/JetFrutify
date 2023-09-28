package com.example.jetfrutify.data.response.clasifyresponse

import com.google.gson.annotations.SerializedName

data class PredictResponse(

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

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("fruit")
	val fruit: Any? = null,

	@field:SerializedName("price_estimation")
	val priceEstimation: Int? = null,

	@field:SerializedName("quality")
	val quality: String? = null
)
