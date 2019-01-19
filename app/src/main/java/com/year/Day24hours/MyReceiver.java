package com.year.Day24hours;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    String packageName = null;
    Uri uri;
    String activity;
    String url;
    int id;
    private static final String TAG = "MyReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        packageName = intent.getStringExtra("PACKAGE_NAME");
        activity = intent.getStringExtra("ACTIVITY");
        url = intent.getStringExtra("URL");
        id = intent.getIntExtra("IDD", 0);

        PendingIntent notification = PendingIntent.getActivity(context, id, new Intent(context, TableActivity.class),0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.io_notifications_black_24dp).setContentTitle(activity).setContentText("تطبيق يومك في 24 ساعة");
        PackageManager packageManager = context.getPackageManager();

         if (url.equals("")) { }
         else{
             if (!url.startsWith("http://") && !url.startsWith("https://")) {
                 Log.d(TAG, "openUrl.onClick() prefixing the URL with protocol: " + "http://" + url);
                 uri = Uri.parse("http://" + url);
             } else {
                 uri = Uri.parse(url);
             }

             Log.d(TAG, "openUrl.onClick() uri: " + uri);
             Intent website = new Intent(Intent.ACTION_VIEW, uri);
             website.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             context.startActivity(website);
         }

        if (null != packageName){
                try {
                    Intent mintent = packageManager.getLaunchIntentForPackage(packageName);
                    if (null != mintent) {
                        context.startActivity(mintent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, e.getMessage(),
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(context, e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

        }

        builder.setContentIntent(notification);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        NotificationManager mm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mm.cancel(1);
        mm.notify(1,builder.build());

    }

}
