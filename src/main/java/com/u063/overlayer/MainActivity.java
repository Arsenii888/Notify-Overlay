package com.u063.overlayer;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    @SuppressLint("MissingPermission")
    public void showNotify(View w){
        EditText et = findViewById(R.id.notify);
        EditText et1 = findViewById(R.id.notifyHead);
        NotificationChannel mChannel = new NotificationChannel("LOLL", "LOL",NotificationManager.IMPORTANCE_LOW);

// Configure the notification channel.
        mChannel.setDescription("LOL");

        mChannel.enableLights(true);
// Sets the notification light color for notifications posted to this
// channel, if the device supports this feature.
        mChannel.setLightColor(Color.RED);

        mChannel.enableVibration(true);
        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

        NotificationManager mNotificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "LOLL")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(et1.getText().toString())
                .setContentText(et.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(MainActivity.this);
        notificationManager.notify(1, builder.build());
    }
}