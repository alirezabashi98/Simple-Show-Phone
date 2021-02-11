package com.example.simple.show.photos

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [AdapterModule::class,CustomModule::class])
interface AdapterComponent {

    @Named("hi")
    fun setStrings(): Set<String>

    @Named("hi2")
    fun setStrings2(): Set<String>

    fun buildCustom():CustomClass

    fun buildAdapter(): Adapter

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {


        @BindsInstance
        fun setApplication(application: Application): Builder

        fun build(): AdapterComponent

    }

}