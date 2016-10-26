// Brenna Pavlinchak
// MDF3 - 1605
// Form

package com.example.ravenmargret.exercise01;

import java.io.Serializable;

public class Form implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
    String mFirstName;
    String mLastName;
    int mAge;

    public Form(String mFirstName, String mLastName, int mAge)
    {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mAge = mAge;
    }

    public String getmFirstName() {return mFirstName;}
    public String getmLastName() {return mLastName;}
    public int getmAge() {return mAge;}


    public void setmFirstName(String mFirstName) {this.mFirstName = mFirstName;}
    public void setmLastName(String mLastName) {this.mLastName = mLastName;}
    public void setmAge(int mAge) {this.mAge = mAge;}

    @Override
    public String toString()
    {
        return mFirstName;
    }

    @Override
    public boolean equals(Object o)
    {
        Form formCheck = (Form)o;

        if (formCheck.mFirstName.equals(mFirstName) && formCheck.mLastName.equals(mLastName) && formCheck.mAge == mAge)
        {
            return true;
        }

        return false;
    }
}
