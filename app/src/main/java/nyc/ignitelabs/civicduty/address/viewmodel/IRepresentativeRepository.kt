package nyc.ignitelabs.civicduty.address.viewmodel

import nyc.ignitelabs.civicduty.address.data.model.RepresentativesResponse
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError
import nyc.ignitelabs.civicduty.common.DataOrError

interface IRepresentativesRepository {

    // TODO: should NOT return RepresentativesResponse here. It's a data layer model and it should be mapped to
    // Representatives object in the Repository
    suspend fun representatives( address : String): DataOrError<DisplayableError, RepresentativesResponse>

}