package nyc.ignitelabs.civicduty.address.data.dataprovider

import nyc.ignitelabs.civicduty.address.data.model.RepresentativesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RepresenativesWebService {
    @GET("/civicinfo/v2/representatives")
    suspend fun representatives(@Query("address") address: String): Response<RepresentativesResponse>
}