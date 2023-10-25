package com.after_project.appmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppMessageReceiver {
    BroadcastReceiver receiver;
    AppMessageReceiver(ReceiverCallback receiverCallback){
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                receiverCallback.onReceiveMessage(
                        intent.getIntExtra("param", -1),
                        intent.getStringExtra("event"),
                        intent.getStringExtra("data")
                );
            }
        };
    }
    protected interface ReceiverCallback {
        void onReceiveMessage(int param, String event, String data);
    }
}