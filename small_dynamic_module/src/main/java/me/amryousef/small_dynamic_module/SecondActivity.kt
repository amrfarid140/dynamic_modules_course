package me.amryousef.small_dynamic_module

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitinstall.SplitInstallManager
import kotlinx.android.synthetic.main.activity_second.*
import me.amryousef.example.applicationComponent
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerSecondActivityComponent.builder()
            .applicationComponent(application.applicationComponent())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Activity"
        setResult(Activity.RESULT_OK)
        finish_activity.setOnClickListener { finish() }
    }
}