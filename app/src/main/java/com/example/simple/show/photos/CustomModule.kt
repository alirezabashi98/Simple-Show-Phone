package com.example.simple.show.photos

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CustomModule {

    @Provides
    fun createCustomClass(@Named("hi2") strings: Set<String>): CustomClass {
        Log.i("TAG_Test","value string : $strings")
        return CustomClass(strings)
    }

}