package nyc.ignitelabs.civicduty.address.viewmodel

import androidx.lifecycle.*
import androidx.navigation.NavDirections
import nyc.ignitelabs.civicduty.address.data.dataprovider.RepresentativesRepository
import nyc.ignitelabs.civicduty.address.view.AddressDetailsFragmentDirections
import nyc.ignitelabs.civicduty.address.view.AddressEditFragmentDirections
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError

class AddressViewModel : ViewModel() {
    private val _address = MutableLiveData<String>()
    private val _error = MutableLiveData<DisplayableError>()
    private val _navigate = MutableLiveData<NavDirections>()
    private val _repo = RepresentativesRepository()

    val representatives = _address.switchMap {
        liveData {
            emit(_repo.representatives(it))
        }
    }

    val address : LiveData<String> = _address
    val error : LiveData<DisplayableError> = _error
    val navigate : LiveData<NavDirections> = _navigate

    fun editAddress(){
        _navigate.value = AddressDetailsFragmentDirections.actionMainToEditView()
    }

    fun updatedAddress( address : String ){
        _address.value = address
        _navigate.value = AddressEditFragmentDirections.actionEditViewToMain()
    }
}
