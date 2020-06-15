package me.amryousef.small_dynamic_module

import dagger.Component
import me.amryousef.example.ApplicationComponent

@DynamicModuleScope
@Component(dependencies = [ApplicationComponent::class])
interface SecondActivityComponent {
    fun inject(secondActivity: SecondActivity)
}