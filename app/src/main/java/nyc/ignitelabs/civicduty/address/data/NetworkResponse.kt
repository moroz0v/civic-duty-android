package nyc.ignitelabs.civicduty.address.data

import nyc.ignitelabs.civicduty.address.data.model.RepresentativesResponse
import nyc.ignitelabs.civicduty.common.DataOrError
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError

//TODO: needs to be re-usable. We should add generics to this
data class NetworkResponse(val error: DisplayableError, val data: RepresentativesResponse) :
    DataOrError<DisplayableError, RepresentativesResponse> {
    override fun data(): RepresentativesResponse {
       return data
    }

    override fun error(): DisplayableError {
        return error
    }

}
