package com.sample.brazepoc.util

import android.app.Notification
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.appboy.models.push.BrazeNotificationPayload
import com.braze.IBrazeNotificationFactory
import com.sample.brazepoc.MyApplication

class BrazeNotificationFactory : IBrazeNotificationFactory {
    override fun createNotification(brazeNotificationPayload: BrazeNotificationPayload): Notification? {
        Log.d("MyApplication", "BrazeNotificationFactory-> createNotification")
        Handler(Looper.getMainLooper()).post {
            val text = brazeNotificationPayload.contentText
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(MyApplication.instance.applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.START, 50, 50)
            toast.show()
        }
        return null
    }
}