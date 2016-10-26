// Brenna Pavlinchak
// MDF3 - 1605
// Detail Activity

package com.example.ravenmargret.exercise01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends AppCompatActivity
{
    FragmentManager manager;
    public static final String LISTKEY = "listKey";

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
        setContentView(R.layout.activity_detail);

        manager = getFragmentManager();

        Intent callingIntent = getIntent();
        String firstName = callingIntent.getStringExtra(CRUDReceiver.EXTRA_FIRST_NAME);
        String lastName = callingIntent.getStringExtra(CRUDReceiver.EXTRA_LAST_NAME);
        int age = callingIntent.getIntExtra(CRUDReceiver.EXTRA_AGE, 0);

        DetailFragment detailFragment = DetailFragment.createFragment(firstName, lastName, age);
        showDetailFragment(detailFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_delete)
        {
            DetailFragment detailFragment = (DetailFragment)getFragmentManager().findFragmentByTag("detailFrag");

            Form returnedObject = detailFragment.returnForm();

            Intent deleteData = new Intent(CRUDReceiver.ACTION_DELETE_DATA);
            deleteData.putExtra(CRUDReceiver.EXTRA_FIRST_NAME, returnedObject.getmFirstName());
            deleteData.putExtra(CRUDReceiver.EXTRA_LAST_NAME, returnedObject.getmLastName());
            deleteData.putExtra(CRUDReceiver.EXTRA_AGE, returnedObject.getmAge());

            sendBroadcast(deleteData);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        IntentFilter fliter1 = new IntentFilter();
        fliter1.addAction(CRUDReceiver.ACTION_UPDATE_LIST);

        registerReceiver(mReceiver, fliter1);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        unregisterReceiver(mReceiver);
    }

    private void showDetailFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container, detailFrag, "detailFrag").commit();
    }

}
