package me.amryousef.example

import android.app.Application
import com.google.android.play.core.splitinstall.SplitInstallManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InstallManagerModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun splitInstallManager(): SplitInstallManager

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}