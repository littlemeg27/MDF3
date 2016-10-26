// Brenna Pavlinchak
// MDF3 - 1605
// Image Intent Service

package com.example.ravenmargret.exercise02;

import android.app.IntentService;
import android.content.Intent;

import java.util.IllegalFormatFlagsException;

public class ImageIntentService extends IntentService
{
    public static final String EXTRA_IMAGE_NAME =
            "com.fullsail.android.Exercise02.EXTRA_IMAGE_NAME";

    public ImageIntentService()
    {
        super("ImageIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent)
    {
        if(!intent.hasExtra(EXTRA_IMAGE_NAME))
        {
            throw new IllegalArgumentException("You need to pass in the name of the image");
        }

        String imageName = intent.getStringExtra(EXTRA_IMAGE_NAME);

        String imageData = ImageDataHelper.

        //
    }
}
