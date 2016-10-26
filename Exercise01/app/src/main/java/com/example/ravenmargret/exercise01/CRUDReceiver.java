// Brenna Pavlinchak
// MDF3 - 1605
// CRUD Receiver

package com.example.ravenmargret.exercise01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CRUDReceiver extends BroadcastReceiver
{
    public static final String ACTION_SAVE_DATA =
            "com.fullsail.android.ACTION_SAVE_DATA";
    public static final String ACTION_DELETE_DATA =
            "com.fullsail.android.ACTION_DELETE_DATA";
    public static final String EXTRA_FIRST_NAME =
            "com.fullsail.android.EXTRA_FIRST_NAME";
    public static final String EXTRA_LAST_NAME =
            "com.fullsail.android.EXTRA_LAST_NAME";
    public static final String EXTRA_AGE =
            "com.fullsail.android.EXTRA_AGE";
    public static final String ACTION_UPDATE_LIST =
            "com.fullsail.android.ACTION_UPDATE_LIST";
    public static final String ACTION_VIEW_DATA =
            "com.fullsail.android.ACTION_VIEW_DATA";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(ACTION_SAVE_DATA))
        {
            String firstName = intent.getStringExtra(EXTRA_FIRST_NAME);
            String lastName = intent.getStringExtra(EXTRA_LAST_NAME);
            int age = intent.getIntExtra(EXTRA_AGE, 0);

            Form form = new Form(firstName, lastName, age);
            FormUtil.save(form, context);

            Intent updateIntent = new Intent(ACTION_UPDATE_LIST);
            context.sendBroadcast(updateIntent);
        }

        if (intent.getAction().equals(ACTION_DELETE_DATA))
        {
            String firstName = intent.getStringExtra(EXTRA_FIRST_NAME);
            String lastName = intent.getStringExtra(EXTRA_LAST_NAME);
            int age = intent.getIntExtra(EXTRA_AGE, 0);

            Form form = new Form(firstName, lastName, age);
            FormUtil.delete(form, context);

            Intent deleteIntent = new Intent(ACTION_UPDATE_LIST);
            context.sendBroadcast(deleteIntent);
        }

    }
}
