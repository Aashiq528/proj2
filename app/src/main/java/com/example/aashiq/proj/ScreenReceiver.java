package com.example.aashiq.proj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.content.Context.WIFI_SERVICE;

public class ScreenReceiver extends BroadcastReceiver {


    public static boolean wasScreenOn = true;

    public void onReceive(final Context context, final Intent intent) {
        Log.e("LOB", "onReceive");

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

            wasScreenOn = false;

            Log.e("Screen ", "shutdown now");


            Intent i = new Intent("wifi_off");
            i.putExtra("message", "off");
            context.sendBroadcast(i);


        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // and do whatever you need to do here
            wasScreenOn = true;
            Log.e("Screen ", "awaked now");

            Intent i1 = new Intent("wifi_off");
            i1.putExtra("message", "on");
            context.sendBroadcast(i1);


            Intent i = new Intent(context, MainActivity.class);  //MyActivity can be anything which you want to start on bootup...
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        } else if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.e("LOB", "userpresent");
            //  Log.e("LOB","wasScreenOn"+wasScreenOn);


        }
    }


}


///// yeaaahhhthnkuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu  /// normal ekta jinish ami vulei gesilam