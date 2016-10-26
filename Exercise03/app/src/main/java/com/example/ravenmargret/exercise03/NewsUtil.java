// Brenna Pavlinchak
// MDF3 - 1605
// News Util

package com.example.ravenmargret.exercise03;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewsUtil
{
    public static void save(ArrayList<News> news, Context context)
    {
        try
        {
            FileOutputStream fileOut = context.openFileOutput("test.txt", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(news);
            objectOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<News> load(Context context)
    {
        ArrayList<News> savedForm = new ArrayList<News>();
        try
        {
            FileInputStream fileIn = context.openFileInput("test.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            savedForm = (ArrayList<News>)objectIn.readObject();
            objectIn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return savedForm;
    }

    public static void save(News news, Context context)
    {
        ArrayList<News> loadedItem = load(context);

        if (loadedItem == null)
        {
            loadedItem = new ArrayList<>();
        }

        loadedItem.add(news);
        save(loadedItem, context);
    }

    public static void delete(News object, Context context)
    {
        ArrayList<News> loadedItem = load(context);

        if (loadedItem != null)
        {
            loadedItem.remove(object);
            Log.e("Array list", loadedItem.size() + "size");
            save(loadedItem, context);
        }
    }
}
