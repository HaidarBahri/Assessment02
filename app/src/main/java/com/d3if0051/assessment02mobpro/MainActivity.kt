package com.d3if0051.assessment02mobpro

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.d3if0051.assessment02mobpro.viewModels.FirebaseUserViewModel


class MainActivity : AppCompatActivity() {

    companion object{
        const val CHANNEL_ID = "updater"
        const val PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = getString(R.string.channel_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = getString(R.string.channel_desc)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager?
            manager?.createNotificationChannel(channel)
        }
    }
}
