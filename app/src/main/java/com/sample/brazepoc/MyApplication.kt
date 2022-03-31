package com.sample.brazepoc

import android.app.Application
import android.util.Log
import com.braze.Braze
import com.braze.BrazeActivityLifecycleCallbackListener
import com.sample.brazepoc.util.BrazeNotificationFactory
import com.braze.configuration.BrazeConfig


class MyApplication : Application() {
    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("MyApplication", "onCreate")

        val brazeConfig: BrazeConfig = BrazeConfig.Builder()
            .setIsTouchModeRequiredForHtmlInAppMessages(false)
            .build()
        Braze.configure(this, brazeConfig)

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