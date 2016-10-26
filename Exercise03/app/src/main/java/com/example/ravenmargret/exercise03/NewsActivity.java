// Brenna Pavlinchak
// MDF3 - 1605
// News Activity

package com.example.ravenmargret.exercise03;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class NewsActivity extends AppCompatActivity implements NewsFragment.OnFragmentInteractionListener
{
    FragmentManager manager;

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_news);

        manager = getFragmentManager();

        NewsFragment listFragment = new NewsFragment();
        showListFragment(listFragment);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent alarmIntent = new Intent(this, NewsIntentService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 60000, pendingIntent);
    }

    private void showListFragment(Fragment listFrag)
    {
        manager.beginTransaction().replace(R.id.container, listFrag, "listFrag").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent nextActivity = new Intent(this, NewsActivity.class);
        startActivityForResult(nextActivity, 4040);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        NewsFragment fragment = (NewsFragment) getFragmentManager().findFragmentById(R.id.container);
        fragment.loadData();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        IntentFilter filter1 = new IntentFilter();
        filter1.addAction(NewsReceiver.ACTION_BOOT_COMPLETED);

        registerReceiver(mReceiver, filter1);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        unregisterReceiver(mReceiver);
    }

    @Override
    public void onFragmentInteraction(News newsObject)
    {
        Uri webpage = Uri.parse(newsObject.getmURL()); //Intent to open webpage
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
