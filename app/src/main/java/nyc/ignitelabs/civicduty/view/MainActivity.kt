package nyc.ignitelabs.civicduty.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import nyc.ignitelabs.civicduty.R

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.address)

        val submitButton = findViewById<Button>(R.id.button_submit)

        submitButton.setOnClickListener {
            var text = textView?.text.toString()

            var editIntent =  Intent(this@MainActivity, EditActivity::class.java)

            editIntent.putExtra("address", text)

            startActivityForResult( editIntent, 4)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when( requestCode ){
            4 -> navigate( resultCode, data)
        }
    }

    fun navigate( resultCode: Int, data: Intent?){
        if( resultCode == Activity.RESULT_OK) {
            textView?.text = data?.getStringExtra("address")
        }
    }
}
