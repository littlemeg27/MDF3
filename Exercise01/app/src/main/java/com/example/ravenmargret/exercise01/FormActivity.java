// Brenna Pavlinchak
// MDF3 - 1605
// Form Activity

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

public class FormActivity extends AppCompatActivity
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
        setContentView(R.layout.activity_form);

        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showFormFragment(formFragment);
    }

    private void showFormFragment(Fragment formFrag)
    {
        manager.beginTransaction().replace(R.id.container, formFrag, "formFrag").commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_save)
        {
            //When they click the save button
            FormFragment getFrag = (FormFragment)getFragmentManager().findFragmentByTag("formFrag");

            String firstName = getFrag.firstNameText.getText().toString();
            String lastName = getFrag.lastNameText.getText().toString();
            String age = getFrag.ageText.getText().toString();
            int ageInt = Integer.parseInt(age);

            Intent saveIntent = new Intent(CRUDReceiver.ACTION_SAVE_DATA);
            saveIntent.putExtra(CRUDReceiver.EXTRA_FIRST_NAME, firstName);
            saveIntent.putExtra(CRUDReceiver.EXTRA_LAST_NAME, lastName);
            saveIntent.putExtra(CRUDReceiver.EXTRA_AGE, ageInt);

            sendBroadcast(saveIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
