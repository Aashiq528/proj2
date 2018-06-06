package com.example.aashiq.proj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(getApplicationContext(), LockService.class));



    }

    @Override
    protected void onResume() {
        super.onResume();

       registerReceiver(broadcastReceiver ,new IntentFilter("wifi_off"));


    }

    @Override
    protected void onPause() {
        super.onPause();

        registerReceiver(broadcastReceiver ,new IntentFilter("wifi_off"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        registerReceiver(broadcastReceiver ,new IntentFilter("wifi_off"));
    }

    @Override
    protected void onStop() {
        super.onStop();

        registerReceiver(broadcastReceiver ,new IntentFilter("wifi_off"));
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            switch (intent.getStringExtra("message")){

                case "off":

                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                    break;

                case "on":
                    WifiManager wifi1 = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi1.setWifiEnabled(true);
                    break;


            }


        }
    };



}
