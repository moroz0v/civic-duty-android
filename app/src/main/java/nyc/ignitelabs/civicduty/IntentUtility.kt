package nyc.ignitelabs.civicduty

import android.content.Context
import android.content.Intent
import nyc.ignitelabs.civicduty.view.EditActivity

fun  addressEditIntent(context: Context, address: String ) : Intent {
    return Intent(context, EditActivity::class.java).putExtra(Constants.KEY_ADDRESS, address)
}

fun  addressEditSuccessIntent(address: String ) : Intent {
    return Intent().putExtra(Constants.KEY_ADDRESS, address)
}