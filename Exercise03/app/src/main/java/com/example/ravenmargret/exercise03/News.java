// Brenna Pavlinchak
// MDF3 - 1605
// News

package com.example.ravenmargret.exercise03;

import java.io.Serializable;

public class News implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
    String mTitle;
    String mURL;
    String mArticle;

    public News(String mTitle, String mURL, String mArticle)
    {
        this.mTitle = mTitle;
        this.mURL = mURL;
        this.mArticle = mArticle;
    }

    public String getmTitle() {return mTitle;}
    public String getmURL() {return mURL;}
    public  String getmArticle() {return mArticle;}


    public void setmTitle(String mTitle) {this.mTitle = mTitle;}
    public void setmURL(String mURL) {this.mURL = mURL;}
    public void setmArticle(String mArticle) {this.mArticle = mArticle;}

    @Override
    public String toString()
    {
        return mTitle;
    }
}
