package nyc.ignitelabs.civicduty.view

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.button_submit
import nyc.ignitelabs.civicduty.Constants.KEY_ADDRESS
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.addressEditSuccessIntent

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit)

        button_submit.setOnClickListener {
            setResult(RESULT_OK, addressEditSuccessIntent(address_edit.text.toString()))

            this@EditActivity.finish()
        }

        address_edit.text = SpannableStringBuilder(intent?.getStringExtra(KEY_ADDRESS))
    }
}