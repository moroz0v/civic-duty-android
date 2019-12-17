package nyc.ignitelabs.civicduty.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.Constants.CODE_REQUEST_ADDRESS
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.addressEditIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button_submit.setOnClickListener {
            startActivityForResult(
                addressEditIntent(this@MainActivity, address.text.toString()),
                CODE_REQUEST_ADDRESS)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( resultCode != Activity.RESULT_OK ){
            //TODO: handle error
            return
        }

        when( requestCode ){
            CODE_REQUEST_ADDRESS ->
                address.text = data?.getStringExtra(Constants.KEY_ADDRESS)

        }
    }
}
