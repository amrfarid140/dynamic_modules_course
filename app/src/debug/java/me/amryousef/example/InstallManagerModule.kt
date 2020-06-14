package me.amryousef.example

import android.app.Application
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManagerFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InstallManagerModule {

    @Singleton
    @Provides
    fun providerSplitInstallManager(application: Application): SplitInstallManager {
        return FakeSplitInstallManagerFactory.create(application)
    }
}