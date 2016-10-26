// Brenna Pavlinchak
// MDF3 - 1605
// Form Activity

package com.example.ravenmargret.exercise04;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FormActivity extends AppCompatActivity
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showListFragment(formFragment);
    }

    private void showListFragment(Fragment formFrag)
    {
        manager.beginTransaction().replace(R.id.container, formFrag, "formFrag").commit();
    }

}
