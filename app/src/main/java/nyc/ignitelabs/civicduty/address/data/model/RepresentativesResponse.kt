package nyc.ignitelabs.civicduty.address.data.model

import com.google.gson.annotations.SerializedName

class RepresentativesResponse(

    @SerializedName("divisions")
    val divisions: Map<String, Division>,
    @SerializedName("offices")
    val offices: Array<Office>,
    @SerializedName("officials")
    val officials: Array<Official>

)