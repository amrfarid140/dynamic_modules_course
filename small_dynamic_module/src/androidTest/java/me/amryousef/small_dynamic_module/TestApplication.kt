package me.amryousef.small_dynamic_module

import android.app.Application
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import me.amryousef.example.ApplicationComponent
import me.amryousef.example.MyApplication

class TestApplication : MyApplication() {
    override fun buildApplicationComponent(): ApplicationComponent {
        return DaggerTestComponent.builder()
            .application(this)
            .build()
    }
}

@Component(modules = [TestModule::class])
interface TestComponent : ApplicationComponent {
    @Component.Builder
    interface Builder {
        fun build(): TestComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}

@Module
class TestModule {
    @Provides
    fun splitInstallModule(application: Application): SplitInstallManager =
        SplitInstallManagerFactory.create(application)
}
