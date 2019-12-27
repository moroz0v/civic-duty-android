package nyc.ignitelabs.civicduty.address.viewmodel.models


class PoliticalOfficial(
    private val role: String,
    private val name: String,
    private val photoUrl: String,
    private val roleDescription: String
) {
    fun role(): String {
        return role
    }

    fun name(): String {
        return name
    }

    fun photoUrl(): String {
        return photoUrl
    }

    fun roleDescription(): String {
        return roleDescription
    }

}