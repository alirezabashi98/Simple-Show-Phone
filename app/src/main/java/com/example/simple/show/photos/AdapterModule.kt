package com.example.simple.show.photos

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.multibindings.*
import java.util.*
import javax.inject.Named

@Module
class AdapterModule {

    @Named("hi")
    @Provides
    @IntoSet
    fun intoSet(): String = "hi"

    @Named("hi2")
    @Provides
    @ElementsIntoSet
    fun intoSet2(): Set<String> = HashSet(Arrays.asList("hi2", "hi3", "hi4"))

    @Named("hi2")
    @Provides
    @IntoSet
    fun intoSet3(): String = "hi6"

    @Provides
    @IntoMap
    @StringKey("salam")
    fun intoMap(): String = "salam"

//    @Provides
//    @IntoMap
//    fun intoMap3(): Map<String,String> = hashMapOf<String,String>("salam" to "salam")

    @Provides
    @IntoMap
    @ClassKey(AdapterModule::class)
    fun intoMap2(): String = "salam2"

    @Provides
    fun provideOptions(): RequestOptions =
        RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)

    @Provides
    fun provideManager(requestOptions: RequestOptions, application: Application): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }


    @Provides
    fun provideImages(): List<Int> {
        val images = arrayListOf<Int>(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.images8,
            R.drawable.image9,
            R.drawable.image10,
        )

        return images
    }

}