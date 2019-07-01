package com.asiaplus.push;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.crashlytics.android.Crashlytics;
import com.asiaplus.push.model.ImageQueueSingleton;
import com.asiaplus.push.util.AnalyticsManager;
import com.asiaplus.push.util.Language;
import com.asiaplus.push.util.NotificationManager;
import com.asiaplus.push.util.SyncManager;
import com.asiaplus.push.util.Foreground;
import com.clostra.newnode.NewNode;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Zed on 6/30/2015.
 */

public class PushApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        NewNode.init();
        NewNode.setLogLevel(1);
        Foreground.init(this);

        ImageQueueSingleton.getInstance(this);

        Fabric.with(this, new Crashlytics());
        AnalyticsManager.getAnalyticsManager().setAnalyticsManager(AnalyticsManager.AnalyticType.FABRIC, this);

        Language.setDeviceToSavedLanguage(getApplicationContext());

        //Initialize push
        NotificationManager.getNotificationManager().registerForNotifications(this);

        // Set up the sync manager
        SyncManager.getSyncManager().setApplicationContext(getApplicationContext());


        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("is_notification", true);
        //Notification.DefaultNotificationHandler.onNotificationClickIntent(i, Notification.DefaultNotificationHandler.NotificationType.plain);
        //Notification.DefaultNotificationHandler.onNotificationClickIntent(i, Notification.DefaultNotificationHandler.NotificationType.media);

        //PushClient.start();
    }

    @Override
    protected void attachBaseContext(Context base) {
        Language.setDeviceToSavedLanguage(base);
        super.attachBaseContext(base);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Language.setDeviceToSavedLanguage(getApplicationContext());
    }

}
