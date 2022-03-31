package com.sample.brazepoc

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent

import android.app.Activity
import android.net.Uri

import android.os.Build
import android.provider.Settings
import android.util.Log
import com.braze.Braze


/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MyApplication", Braze.getInstance(applicationContext).deviceId)
        /* if (Build.VERSION.SDK_INT >= 23) {
             if (!Settings.canDrawOverlays(this)) {
                 val intent = Intent(
                     Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                     Uri.parse("package:$packageName")
                 )
                 startActivityForResult(intent, 1234)
             }
         }*/
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}