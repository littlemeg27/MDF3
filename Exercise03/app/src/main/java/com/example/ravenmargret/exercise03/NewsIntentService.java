// Brenna Pavlinchak
// MDF3 - 1605
// News Intent Service

package com.example.ravenmargret.exercise03;

import android.app.Activity;
import android.app.Fragment;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class NewsIntentService extends IntentService
{
    public static final int START_NOTI = 1;

    public NewsIntentService()
    {
        super("NewsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        String data = NewsDataHelper.getNewsData();
        News newsObject = NewsDataHelper.parseNewsData(data);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentText(newsObject.getmArticle());
        builder.setContentTitle(newsObject.getmTitle());
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationCompat.BigTextStyle styles = new NotificationCompat.BigTextStyle(); //Big style code
        styles.setBigContentTitle(newsObject.getmTitle());
        styles.bigText(newsObject.getmArticle());
        builder.setStyle(styles);

        String title = newsObject.getmTitle(); //Grab the strings
        String article = newsObject.getmArticle();
        String url = newsObject.getmURL();

        Intent saveIntent = new Intent(NewsReceiver.ACTION_SAVE_DATA); //Intent to save the data
        saveIntent.putExtra(NewsReceiver.EXTRA_TITLE, title);
        saveIntent.putExtra(NewsReceiver.EXTRA_ARTICLE, article);
        saveIntent.putExtra(NewsReceiver.EXTRA_URL, url);

        PendingIntent savePendingIntent = PendingIntent.getBroadcast(this, 0, saveIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(android.R.drawable.ic_menu_add, "Save", savePendingIntent); //Pending Intent to save Data

        Uri webpage = Uri.parse(newsObject.getmURL()); //Intent to open webpage
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, webIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent); //Pending Intent to open webpage

        notificationManager.notify(START_NOTI, builder.build());
    }
}