package me.amryousef.example

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InstallManagerModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun application(application: Application): Builder
    }
}