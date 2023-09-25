package com.example.jetfrutify.data.response.productresponse

import com.google.gson.annotations.SerializedName

data class ListProductResponse(

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

	@field:SerializedName("product")
	val product: List<ProductItem?>? = null
)

data class ProductItem(

	@field:SerializedName("PRODUCT_FILE_PATH")
	val pRODUCTFILEPATH: String? = null,

	@field:SerializedName("USER_TOKEN")
	val uSERTOKEN: String? = null,

	@field:SerializedName("USER_EMAIL")
	val uSEREMAIL: String? = null,

	@field:SerializedName("USER_ID")
	val uSERID: Int? = null,

	@field:SerializedName("USER_ADDRESS")
	val uSERADDRESS: String? = null,

	@field:SerializedName("PRODUCT_ID")
	val pRODUCTID: Int? = null,

	@field:SerializedName("PRODUCT_NAME")
	val pRODUCTNAME: String? = null,

	@field:SerializedName("PRODUCT_QUALITY")
	val pRODUCTQUALITY: String? = null,

	@field:SerializedName("FRUIT_ID")
	val fRUITID: Int? = null,

	@field:SerializedName("PRODUCT_UNIT")
	val pRODUCTUNIT: String? = null,

	@field:SerializedName("PRODUCT_DESCRIPTION")
	val pRODUCTDESCRIPTION: String? = null,

	@field:SerializedName("PRODUCT_PRICE")
	val pRODUCTPRICE: Int? = null,

	@field:SerializedName("USER_PHONE")
	val uSERPHONE: String? = null,

	@field:SerializedName("USER_PASSWORD")
	val uSERPASSWORD: String? = null,

	@field:SerializedName("FRUIT_NAME")
	val fRUITNAME: String? = null,

	@field:SerializedName("USER_TOKEN_EXPIRED")
	val uSERTOKENEXPIRED: String? = null,

	@field:SerializedName("USER_ROLE")
	val uSERROLE: String? = null,

	@field:SerializedName("USER_FULLNAME")
	val uSERFULLNAME: String? = null
)
