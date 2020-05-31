package me.amryousef.example

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
    }

    private lateinit var installManager: SplitInstallManager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"
        installManager = SplitInstallManagerFactory.create(applicationContext)
        main_to_activity2_button.setOnClickListener {
            installManager.startInstall(
                SplitInstallRequest.newBuilder()
                    .addModule("small_dynamic_module")
                    .build()
            ).addOnSuccessListener {
                getActivityClass()?.let { activityClass ->
                    val intent = Intent(this, activityClass)
                    startActivityForResult(
                        intent,
                        REQUEST_CODE
                    )
                } ?: Toast.makeText(this, "Cannot find activity class", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Install Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getActivityClass(): Class<*>? {
        return try {
            Class.forName("me.amryousef.small_dynamic_module.SecondActivity")
        } catch (exception: ClassNotFoundException) {
            null
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "2nd Activity finished", Toast.LENGTH_SHORT).show()
            installManager.deferredUninstall(listOf("small_dynamic_module"))
        }
    }
}