// Brenna Pavlinchak
// MDF3 - 1605
// Form Util

package com.example.ravenmargret.exercise01;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FormUtil
{
    public static void save(ArrayList<Form> forms, Context context)
    {
        try
        {
            FileOutputStream fileOut = context.openFileOutput("test.txt", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(forms);
            objectOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Form> load(Context context)
    {
        ArrayList<Form> savedForm = new ArrayList<Form>();
        try
        {
            FileInputStream fileIn = context.openFileInput("test.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            savedForm = (ArrayList<Form>)objectIn.readObject();
            objectIn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return savedForm;
    }

    public static void save(Form form, Context context)
    {
        ArrayList<Form> loadedItem = load(context);

        if (loadedItem == null)
        {
            loadedItem = new ArrayList<>();
        }

        loadedItem.add(form);
        save(loadedItem, context);
    }

    public static void delete(Form object, Context context)
    {
        ArrayList<Form> loadedItem = load(context);

        if (loadedItem != null)
        {
            loadedItem.remove(object);
            Log.e("Array list", loadedItem.size() + "size");
            save(loadedItem, context);
        }
    }
}
