package nyc.ignitelabs.civicduty.view

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import nyc.ignitelabs.civicduty.R


class EditActivity : AppCompatActivity() {

    private var address : EditText? = null
    private var buttonSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit)

        address = findViewById(R.id.address_edit)

        buttonSubmit = findViewById(R.id.button_submit)

        buttonSubmit?.setOnClickListener {
            val addressText = address?.text

            val data = Intent()

            data.putExtra("address", addressText.toString())

            setResult(RESULT_OK, data)

            end()
        }

        address?.text = SpannableStringBuilder(intent?.getStringExtra("address"))
    }

    fun end(){
        finish()
    }
}