package nyc.ignitelabs.civicduty.address.data.dataprovider

class RepresentativesRepository {
    var client = webservice

    suspend fun representatives( address : String?) = client.representatives( address )
}