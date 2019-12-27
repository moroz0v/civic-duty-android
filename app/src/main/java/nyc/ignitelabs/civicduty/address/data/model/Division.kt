package nyc.ignitelabs.civicduty.address.data.model

import com.google.gson.annotations.SerializedName

class Division(
    @SerializedName("name")
    val name: String,
    @SerializedName("alsoKnownAs")
    private val alsoKnownAs: Array<String>,
    @SerializedName("officeIndices")
    val officeIndices: IntArray
)