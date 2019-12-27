package nyc.ignitelabs.civicduty.address.viewmodel.models


class PoliticalOffice(private val name: String, private val officials: List<PoliticalOfficial>) {
    fun officeName(): String {
        return name
    }

    fun officials(): List<PoliticalOfficial> {
        return officials
    }

}