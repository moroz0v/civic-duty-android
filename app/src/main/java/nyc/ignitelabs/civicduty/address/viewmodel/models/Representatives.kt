package nyc.ignitelabs.civicduty.address.viewmodel.models


class Representatives(private val address: String, private val districts: List<PoliticalDistrict>) {
    fun address(): String {
        return address
    }

    fun districts(): List<PoliticalDistrict> {
        return districts
    }

}