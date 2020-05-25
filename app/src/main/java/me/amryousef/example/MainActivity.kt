package me.amryousef.example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.amryousef.small_dynamic_module.SecondActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"
        main_to_activity2_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(
                intent,
                REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "2nd Activity finished", Toast.LENGTH_SHORT).show()
        }
    }
}