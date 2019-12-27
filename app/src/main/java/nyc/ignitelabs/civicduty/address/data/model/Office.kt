package nyc.ignitelabs.civicduty.address.data.model

import com.google.gson.annotations.SerializedName

class Office(
    @SerializedName("name")
    private val name: String,
    @SerializedName("divisionId")
    private val divisionId: String,
    @SerializedName("officialIndices")
    private val officialIndices: IntArray
)