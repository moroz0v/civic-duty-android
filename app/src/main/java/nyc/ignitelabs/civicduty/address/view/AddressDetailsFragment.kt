package nyc.ignitelabs.civicduty.address.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.address.viewmodel.AddressViewModel
import nyc.ignitelabs.civicduty.databinding.FragmentAddressDetailsBinding

class AddressDetailsFragment : Fragment() {
    private val vm: AddressViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddressDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_address_details, container, false
        )

        binding.vm = vm

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.reps.observe(viewLifecycleOwner, Observer {
            val k = it
        })
    }
}
