package com.example.simple.show.photos

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AdapterModule::class])
interface AdapterComponent {

    fun buildAdapter(): Adapter

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {


        @BindsInstance
        fun setApplication(application: Application): Builder

        fun build(): AdapterComponent

    }

}