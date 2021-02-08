package com.example.simple.show.photos

import android.app.Application
import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

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