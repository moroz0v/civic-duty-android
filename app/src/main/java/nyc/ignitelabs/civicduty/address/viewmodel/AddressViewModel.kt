package nyc.ignitelabs.civicduty.address.viewmodel

import androidx.lifecycle.*
import androidx.navigation.NavDirections
import nyc.ignitelabs.civicduty.address.data.dataprovider.RepresentativesRepository
import nyc.ignitelabs.civicduty.address.data.model.RepresentativesResponse
import nyc.ignitelabs.civicduty.address.view.AddressDetailsFragmentDirections
import nyc.ignitelabs.civicduty.address.view.AddressEditFragmentDirections
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError

/* TODO:
    1. add loading indicator
    2. add UseCase arch pattern from Clean Architecture.
 */
class AddressViewModel : ViewModel() {
    private val _address = MutableLiveData<String>()
    private val _navigate = MutableLiveData<NavDirections>()
    private val _repo = RepresentativesRepository()
    private val _representativesResponse = _address.switchMap {
        liveData {
            emit(_repo.representatives(it))
        }
    }

    val address : LiveData<String> = _address
    val navigate : LiveData<NavDirections> = _navigate
    val error : LiveData<DisplayableError> = _representativesResponse.map{
        it.error()
    }

    val reps : LiveData<RepresentativesResponse> = _representativesResponse.map{
        it.data()
    }

    fun editAddress(){
        _navigate.value = AddressDetailsFragmentDirections.actionMainToEditView()
    }

    fun updatedAddress( address : String ){
        _address.value = address
        _navigate.value = AddressEditFragmentDirections.actionEditViewToMain()
    }
}
