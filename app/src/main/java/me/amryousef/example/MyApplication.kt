package me.amryousef.example

import android.app.Application
import com.google.android.play.core.splitcompat.SplitCompatApplication

fun Application.applicationComponent(): ApplicationComponent {
    return (this as MyApplication).applicationComponent
}

open class MyApplication : SplitCompatApplication() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        applicationComponent = buildApplicationComponent()
        super.onCreate()
    }

    open fun buildApplicationComponent() =
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
}