package com.sample.brazepoc

import android.app.Application
import android.util.Log
import com.braze.Braze
import com.braze.BrazeActivityLifecycleCallbackListener
import com.sample.brazepoc.util.BrazeNotificationFactory

class MyApplication : Application() {
    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("MyApplication", "onCreate")

        // Override default notification
        Braze.setCustomBrazeNotificationFactory(BrazeNotificationFactory())

        registerActivityLifecycleCallbacks(
            BrazeActivityLifecycleCallbackListener(
                sessionHandlingEnabled = true,
                registerInAppMessageManager = true
            )
        )
    }
}