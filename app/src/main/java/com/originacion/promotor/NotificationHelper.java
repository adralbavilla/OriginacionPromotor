package com.originacion.promotor;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper {

    static PendingIntent pendingIntent;

    public static void displayNotification(Context context, String title, String body, String params){

        Intent intent = new Intent(context, com.originacion.promotor.MainActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("body",body);
        intent.putExtra("parameters",params);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        pendingIntent = PendingIntent.getActivity(context,
                0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = generateNotification(context, title, body, pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0,notification);
    }


    public static Notification generateNotification(Context context, String title, String body, PendingIntent pendingIntent){
            return new NotificationCompat.Builder(context, MainActivity.CHANNEL_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark_normal)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setColor(Color.GREEN)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .build();
    }
}
