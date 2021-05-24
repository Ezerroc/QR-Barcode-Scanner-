package com.example.codescannergostyle;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.codescannergostyle.util.Coupon;

import java.util.Date;

import static com.example.codescannergostyle.SplashScreen.NOTIFICATION_CHANNEL_ID;

public class NotificationPublisher extends BroadcastReceiver {
    public static String NOTIFICATION_ID = "gostyle-notif" ;
    public static String NOTIFICATION = "coupon" ;
    public void onReceive (Context context , Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context. NOTIFICATION_SERVICE ) ;
        Notification notification = intent.getParcelableExtra( NOTIFICATION ) ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "gostyle-notif" , importance) ;
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel) ;
        }
        int id = intent.getIntExtra( NOTIFICATION_ID , 0 ) ;
        assert notificationManager != null;
        notificationManager.notify(id , notification) ;
    }

}
