package me.amryousef.small_dynamic_module

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Activity"
        setResult(Activity.RESULT_OK)
        finish_activity.setOnClickListener { finish() }
    }
}