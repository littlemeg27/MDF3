// Brenna Pavlinchak
// MDF3 - 1605
// Detail Activity

package com.example.ravenmargret.exercise04;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailActivity extends AppCompatActivity
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getFragmentManager();

        DetailFragment detailFragment = new DetailFragment();
        showListFragment(detailFragment);
    }

    private void showListFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container, detailFrag, "detailFrag").commit();
    }

}
