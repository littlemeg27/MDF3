// Brenna Pavlinchak
// MDF3 - 1605
// Person List Activity

package com.example.ravenmargret.exercise01;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PersonListActivity extends AppCompatActivity implements PersonListFragment.OnFragmentInteractionListener
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        manager = getFragmentManager();

        PersonListFragment listFragment = new PersonListFragment();
        showListFragment(listFragment);
    }

    private void showListFragment(Fragment listFrag)
    {
        manager.beginTransaction().replace(R.id.container, listFrag, "listFrag").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent nextActivity = new Intent(this, FormActivity.class);
        startActivityForResult(nextActivity, 4040);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        PersonListFragment fragment = (PersonListFragment) getFragmentManager().findFragmentById(R.id.container);
        fragment.loadData();
    }

    @Override
    public void onFragmentInteraction(Form formObject)
    {
        String firstName = formObject.getmFirstName();
        String lastName = formObject.getmLastName();
        int age = formObject.getmAge();

        Intent viewIntent = new Intent(CRUDReceiver.ACTION_VIEW_DATA);
        viewIntent.putExtra(CRUDReceiver.EXTRA_FIRST_NAME, firstName);
        viewIntent.putExtra(CRUDReceiver.EXTRA_LAST_NAME, lastName);
        viewIntent.putExtra(CRUDReceiver.EXTRA_AGE, age);

        startActivityForResult(viewIntent, 8080);
    }
}
