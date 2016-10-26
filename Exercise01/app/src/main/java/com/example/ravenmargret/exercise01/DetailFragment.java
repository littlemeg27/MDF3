// Brenna Pavlinchak
// MDF3 - 1605
// Detail Fragment

package com.example.ravenmargret.exercise01;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailFragment extends Fragment
{
    public static final String KEYFirst = "FirstKey";
    public static final String KEYLast = "LastKey";
    public static final String KEYAge = "AgeKey";
    Form detailsObject;

    public static DetailFragment createFragment(String firstName, String lastName, int age)
    {
        DetailFragment fragment = new DetailFragment();

        Bundle args = new Bundle();
        args.putString(KEYFirst, firstName);
        args.putString(KEYLast, lastName);
        args.putInt(KEYAge, age);
        fragment.setArguments(args);

        return fragment;
    }

    public DetailFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        String firstName = args.getString(KEYFirst);
        String lastName = args.getString(KEYLast);
        int age = args.getInt(KEYAge);
        detailsObject = new Form(firstName, lastName, age);

        updateText(detailsObject);
    }

    public Form returnForm()
    {
        return detailsObject;
    }


    public void updateText(Form object)
    {
        TextView firstNameText = (TextView) getActivity().findViewById(R.id.firstNameTextView);
        firstNameText.setText(object.getmFirstName());

        TextView lastNameText = (TextView) getActivity().findViewById(R.id.lastNameTextView);
        lastNameText.setText(object.getmLastName());

        TextView ageText = (TextView) getActivity().findViewById(R.id.ageTextView);
        ageText.setText("" + object.getmAge());
    }



}
