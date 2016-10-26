// Brenna Pavlinchak
// MDF3 - 1605
// Form Fragment

package com.example.ravenmargret.exercise01;

import android.app.Fragment;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class FormFragment extends Fragment implements View.OnClickListener
{
    EditText firstNameText;
    EditText lastNameText;
    EditText ageText;

    public FormFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        firstNameText = (EditText)getView().findViewById(R.id.firstNameText);
        lastNameText = (EditText)getView().findViewById(R.id.lastNameText);
        ageText = (EditText)getView().findViewById(R.id.ageText);
    }

    @Override
    public void onClick(View v)
    {
        String firstName = firstNameText.getText().toString();
        String lastName = lastNameText.getText().toString();
        String age = ageText.getText().toString();

        Toast.makeText(getActivity(), "Contact Added", Toast.LENGTH_LONG).show();

        getActivity().finish();
    }
}
