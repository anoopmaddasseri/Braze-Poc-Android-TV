package com.sample.brazepoc.util

import android.app.Notification
import android.content.Intent
import android.os.Build
import com.appboy.models.push.BrazeNotificationPayload
import com.braze.IBrazeNotificationFactory
import com.sample.brazepoc.MyApplication
import com.sample.brazepoc.pipup.PiPupService

class BrazeNotificationFactory : IBrazeNotificationFactory {
    override fun createNotification(payload: BrazeNotificationPayload): Notification? {
        with(MyApplication.instance.applicationContext) {
            val serviceIntent = Intent(this, PiPupService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }
        return null
    }


}