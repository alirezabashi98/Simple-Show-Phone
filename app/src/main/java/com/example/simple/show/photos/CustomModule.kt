package com.example.simple.show.photos

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CustomModule {

    @Provides
    fun createCustomClass(@Named("hi") strings: Set<String>): CustomClass = CustomClass(strings)
//    {
//        Log.i("TAG_Test","value string : $strings")
//        return CustomClass(strings)
//    }

}