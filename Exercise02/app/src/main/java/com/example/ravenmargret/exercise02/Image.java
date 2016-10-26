// Brenna Pavlinchak
// MDF3 - 1605
// Image

package com.example.ravenmargret.exercise02;

import java.io.Serializable;

public class Image implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
    String mImage;

    public Image(String mImage)
    {
        this.mImage = mImage;
    }

    public String getmImage() {return mImage;}


    public void setmImage(String mImage) {this.mImage = mImage;}

    @Override
    public String toString()
    {
        return mImage;
    }
}

//Ok im not sure if this is correct and you want us to save the string or not I believe
// you would then we pass it into the the rest of the project and call the string and put it with the
// rest of the URI and call it.