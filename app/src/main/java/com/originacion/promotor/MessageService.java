package com.originacion.promotor;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationHelper.displayNotification(
                getApplicationContext(),
                remoteMessage.getData().get("title"),
                remoteMessage.getData().get("body"),
                remoteMessage.getData().get("parameters"));

    }
}
