// Brenna Pavlinchak
// MDF3 - 1605
// News Fragment

package com.example.ravenmargret.exercise03;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class NewsFragment extends ListFragment
{
    public static final String ARG_NEWS  = "News";
    final Handler mHandler = new Handler();
    private OnFragmentInteractionListener mListener;
    ArrayList<News> newsObject;

    public NewsFragment()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

//        if(newsObject != null)
//        {
            loadData();
//        }
//        else
//        {
//            Toast.makeText(getActivity(), "The list is empty", Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void onResume()
    {
        loadData();
        super.onResume();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        News n = (News) l.getAdapter().getItem(position);
        mListener.onFragmentInteraction(n);
    }

    public void loadData()
    {
        newsObject = NewsUtil.load(getActivity());
        ArrayAdapter<News> newsArrayAdapter = new ArrayAdapter<News>(getActivity(), android.R.layout.simple_list_item_1, newsObject);
        setListAdapter(newsArrayAdapter);
    }

    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(News newsObject);
    }
}
