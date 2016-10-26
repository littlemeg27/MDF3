// Brenna Pavlinchak
// MDF3 - 1605
// Music

package com.example.ravenmargret.exercise05;

import android.media.Image;
import android.provider.MediaStore;

import java.io.Serializable;

public class Music implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
    String mArtist;
    Image mImage;
    String mTitle;
    long mID;

    public Music(String mArtist, Image mImage, String mTitle, long mID)
    {
        this.mArtist = mArtist;
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mID = mID;
    }

    public String getmArtist() {return mArtist;}
    public Image getmImage() {return mImage;}
    public String getmSong() {return mTitle;}
    public long getmID() {return mID;}


    public void setmArtist(String mArtist) {this.mArtist = mArtist;}
    public void setmImage(Image mImage) {this.mImage = mImage;}
    public void setmTitle(String mTitle) {this.mTitle = mTitle;}
    public void setmID(long mID) {this.mID = mID;}

    @Override
    public String toString()
    {
        return mArtist;
    }
}
