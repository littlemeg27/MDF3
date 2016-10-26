// Brenna Pavlinchak
// MDF3 - 1605
// Map Fragment

package com.example.ravenmargret.exercise04;


import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.telecom.ConnectionRequest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;

//AIzaSyBZgyoqcswppUyLrdVuJnOeEQEkrqpQIsA

public class MapFragment extends Fragment
{
    GoogleMap mMap;

    private static final int ERROR_DIALOG_REQUEST = 9001;

    public MapFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        if(servicesOK())
        {
            return inflater.inflate(R.layout.fragment_map, container, false);
            Toast.makeText(getActivity(), "Ready to map!", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean servicesOK()
    {
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());

        if(isAvailable == ConnectionRequest.SUCCESS)
        {
            return true;
        }
        else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable))
        {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, getActivity(), ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
        {
            Toast.makeText(getActivity(), "Cant connect to mapping service", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
