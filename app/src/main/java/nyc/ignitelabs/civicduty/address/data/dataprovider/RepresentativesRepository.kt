package nyc.ignitelabs.civicduty.address.data.dataprovider


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import nyc.ignitelabs.civicduty.address.data.NetworkResponse
import nyc.ignitelabs.civicduty.address.data.model.RepresentativesResponse
import nyc.ignitelabs.civicduty.address.data.model.RetrofitError
import nyc.ignitelabs.civicduty.common.DataOrError
import nyc.ignitelabs.civicduty.address.viewmodel.IRepresentativesRepository
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError
import okhttp3.ResponseBody
import retrofit2.Response


class RepresentativesRepository : IRepresentativesRepository {
    private var client = webservice
    private val defaultResponse = RepresentativesResponse(emptyMap(), emptyArray(), emptyArray())
    private val defaultError = DisplayableError( DisplayableError.ErrorType.NONE )
    //TODO: use dependency injection
    private val converter = GsonBuilder().create()


    override suspend fun representatives( address : String): DataOrError<DisplayableError, RepresentativesResponse> {

        return client.representatives(address).withDisplayableError(defaultResponse)
    }

    //TODO: move this extension out of repo
    private fun <T> Response<T>.withDisplayableError(default: RepresentativesResponse): DataOrError<DisplayableError, RepresentativesResponse> {
        return try {
            when (this.isSuccessful) {
                true -> {
                    //TODO: map to Representatives object here
                    return NetworkResponse(defaultError, body() as RepresentativesResponse )
                }
                false -> NetworkResponse(errorBody()?.withJson(converter)?: defaultError, default)
            }
        } catch (exception: Throwable) {
            NetworkResponse(DisplayableError(DisplayableError.ErrorType.NETWORK, "network exception"), default)
        }
    }

    //TODO: move this extension out of repo
    private fun ResponseBody.withJson( converter: Gson ) : DisplayableError {
        return converter.fromJson(this.string(), RetrofitError::class.java).withRetrofitError()
    }

    //TODO: move this extension out of repo
    private fun RetrofitError.withRetrofitError() : DisplayableError{
        return DisplayableError(DisplayableError.ErrorType.NETWORK, this.error.message)
    }
}