package com.originacion.promotor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID= "channel1";
    public static final String CHANNEL_NAME= "coding";

    TextView txtLlamar, txtGestionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtLlamar = (TextView)  findViewById(R.id.txtLlamar);
        txtGestionar = (TextView)  findViewById(R.id.txtGestionar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SpannableString contentProspecto = new SpannableString("Llamar a prospecto (Paulina Cruz Perez)");
        SpannableString contentGestionar = new SpannableString("Gestionar oportunidad de venta");
        contentProspecto.setSpan(new UnderlineSpan(), 0, contentProspecto.length(), 0);
        contentGestionar.setSpan(new UnderlineSpan(), 0, contentGestionar.length(), 0);
        txtLlamar.setText(contentProspecto);
        txtGestionar.setText(contentGestionar);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.e("newToken",newToken);
            }
        });
    }


}
