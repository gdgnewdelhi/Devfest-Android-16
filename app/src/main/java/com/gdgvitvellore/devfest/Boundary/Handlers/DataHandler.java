package com.gdgvitvellore.devfest.Boundary.Handlers;

/**
 * Created by Prince Bansal Local on 10/8/2016.
 */


import android.content.Context;
import android.content.SharedPreferences;

import com.gdgvitvellore.devfest.Control.Contracts.PrivateContracts;

import java.util.HashSet;

/**
 * This singleton class will be used to fetch as well as store any data.
 * The sources of data can be both SharedPreferences or Database.
 */

public class DataHandler {

    //Singleton reference
    public static DataHandler myInstance;

    private Context mContext;
    private SharedPreferences mPreferences;

    /**
     * Method to retrieve the singleton reference of this class
     * @param context The context reference passed from the calling class
     * @return Returns static reference of {@link DataHandler} class
     */

    public static DataHandler getInstance(Context context){
        if(myInstance==null){
            myInstance=new DataHandler(context);
        }
        return myInstance;
    }

    /**
     * Private constructor. This class cannot be instantiated outside this class.
     * All class attrbutes should be initialised here
     * @param context The context reference passed while instantiating
     */

    private DataHandler(Context context){
        mContext=context;
        mPreferences=context.getSharedPreferences(PrivateContracts.PREFERENCES_FILE,Context.MODE_PRIVATE);
    }

    /**
     * Use this method to save {@link String} to SharedPreferences
     * @param key Key value of the pair to store
     * @param value String value to store
     */

    private void savePreference(String key, String value) {
        mPreferences.edit().putString(key, value).commit();
    }


    /**
     * Use this method to retrieve {@link String} from SharedPreferences using key
     * @param key Key of the pair to fetch
     * @param def Default String value to fetch
     * @return Returns String value with associated key from SharedPreferences.
     * If value doesn't exist, returns default value passed in argument.
     */

    public String getPreference(String key, String def) {

        return mPreferences.getString(key, def);
    }

    /**
     * Use this method to save {@link boolean} to SharedPreferences
     * @param key Key value of the pair to store
     * @param value boolean value to store
     */

    private void savePreference(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * Use this method to retrieve {@link boolean} from SharedPreferences using key
     * @param key Key of the pair to fetch
     * @param def Default boolean value to fetch
     * @return Returns boolean value with associated key from SharedPreferences.
     * If value doesn't exist, returns default value passed in argument.
     */

    public boolean getPreference(String key, boolean def) {

        return mPreferences.getBoolean(key, def);
    }

    /**
     * Use this method to save {@link int} to SharedPreferences
     * @param key Key value of the pair to store
     * @param value int value to store
     */
    private void savePreference(String key, int value) {
        mPreferences.edit().putInt(key, value).commit();
    }

    /**
     * Use this method to retrieve {@link int} from SharedPreferences using key
     * @param key Key of the pair to fetch
     * @param def Default int value to fetch
     * @return Returns int value with associated key from SharedPreferences.
     * If value doesn't exist, returns default value passed in argument.
     */

    public int getPreference(String key, int def) {

        return mPreferences.getInt(key, def);

    }

    /**
     * Use this method to save {@link HashSet<String>} to SharedPreferences
     * @param key Key value of the pair to store
     * @param value {@link HashSet<String>} value to store
     */

    private void savePreference(String key, HashSet<String> value) {
        mPreferences.edit().putStringSet(key, value).commit();
    }


    /**
     * Use this method to retrieve {@link HashSet} from SharedPreferences using key
     * @param key Key of the pair to fetch
     * @param def Default {@link HashSet<String>} value to fetch
     * @return Returns {@link HashSet<String>} value with associated key from SharedPreferences.
     * If value doesn't exist, returns default value passed in argument.
     */

    public HashSet<String> getPreference(String key, HashSet<String> def) {

        return (HashSet<String>) mPreferences.getStringSet(key, def);

    }

    /**
     * Use this method to change whether user opened the app for first time or not.
     * @param isFirstTimeUser pass true to set first time user and false if he has already been t the app before
     */
    public void saveFirstTimeUser(boolean isFirstTimeUser) {
        savePreference("firstTimeUser", isFirstTimeUser);
    }

    /**
     * Use this method to know whether user is a first time user or not
     * @return Returns true if yes else false
     * If value doesn't exist, returns true.
     */
    public boolean isFirstTimeUser() {
        return getPreference("firstTimeUser", true);
    }

}