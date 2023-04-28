package com.lionsmatchgame.sport

import android.app.Application
import com.onesignal.OneSignal

class App : Application()  {

    private val ONESIGNAL_APP_ID = "6457ee00-61ba-4d82-940a-6a8545428938"

    override fun onCreate() {
        super.onCreate()
        initOneConfig()
    }

    private fun initOneConfig() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this)

        OneSignal.unsubscribeWhenNotificationsAreDisabled(true)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}