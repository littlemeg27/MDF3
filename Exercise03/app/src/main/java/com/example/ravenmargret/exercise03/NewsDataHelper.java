// Brenna Pavlinchak
// MDF3 - 1605
// News Data Helper

package com.example.ravenmargret.exercise03;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


public class NewsDataHelper
{
    static String NEWS_URL = "http://api.nytimes.com/svc/topstories/v2/technology.json?api-key=30832929dc824204b77c1639abc449f9";

    public static String getNewsData()
    {
        String data = null;

        try
        {
            URL url = new URL(NEWS_URL);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();

            InputStream is = connection.getInputStream();
            data = IOUtils.toString(is);
            is.close();

            connection.disconnect();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public static News parseNewsData(String data)
    {
        News info = null;

        try
        {
            JSONObject newsData = new JSONObject(data);
            JSONArray resultsArray = newsData.getJSONArray("results");

            Random randomJSON = new Random();
            int index = randomJSON.nextInt(resultsArray.length());

            JSONObject object = resultsArray.getJSONObject(index);

            String title = object.getString("title");
            String url = object.getString("url");
            String article = object.getString("abstract");

            info = new News(title, url, article);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        return info;
    }
}
