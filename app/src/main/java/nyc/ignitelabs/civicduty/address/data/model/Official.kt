package nyc.ignitelabs.civicduty.address.data.model

import com.google.gson.annotations.SerializedName

class Official(
    @SerializedName("name")
    private val name: String,
    @SerializedName("party")
    private val party: String,
    @SerializedName("photoUrl")
    private val photoUrl: String
)