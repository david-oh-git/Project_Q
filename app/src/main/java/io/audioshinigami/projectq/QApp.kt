package io.audioshinigami.projectq

import android.app.Application
import timber.log.Timber

class QApp: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG)
            Timber.plant( Timber.DebugTree() )
    }
}