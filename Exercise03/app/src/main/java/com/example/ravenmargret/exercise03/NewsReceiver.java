// Brenna Pavlinchak
// MDF3 - 1605
// News Receiver

package com.example.ravenmargret.exercise03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NewsReceiver extends BroadcastReceiver
{
    public static final String ACTION_BOOT_COMPLETED =
            "com.fullsail.android.ACTION_BOOT_COMPLETED";
    public static final String ACTION_SAVE_DATA =
            "com.fullsail.android.ACTION_SAVE_DATA";
    public static final String EXTRA_TITLE =
            "com.fullsail.android.EXTRA_TITLE";
    public static final String EXTRA_URL =
            "com.fullsail.android.EXTRA_URL";
    public static final String EXTRA_ARTICLE =
            "com.fullsail.android.EXTRA_ARTICLE";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals(ACTION_SAVE_DATA))
        {
            String title = intent.getStringExtra(EXTRA_TITLE);
            String url = intent.getStringExtra(EXTRA_URL);
            String article = intent.getStringExtra(EXTRA_ARTICLE);

            News news = new News(title, url, article);
            NewsUtil.save(news, context);

            Intent updateIntent = new Intent(ACTION_BOOT_COMPLETED);
            context.sendBroadcast(updateIntent);
        }
    }
}
