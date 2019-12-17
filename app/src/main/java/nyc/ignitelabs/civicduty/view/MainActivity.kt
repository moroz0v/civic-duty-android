package nyc.ignitelabs.civicduty.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.Constants.CODE_REQUEST_ADDRESS
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.addressEditIntent

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.address)

        val submitButton = findViewById<Button>(R.id.button_submit)

        submitButton.setOnClickListener {
            startActivityForResult(
                addressEditIntent(this@MainActivity, textView?.text.toString()), CODE_REQUEST_ADDRESS)
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
               textView?.text = data?.getStringExtra(Constants.KEY_ADDRESS)

        }
    }
}
