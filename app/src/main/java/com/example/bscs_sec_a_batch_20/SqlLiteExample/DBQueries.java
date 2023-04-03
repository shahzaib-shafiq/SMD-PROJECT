package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DBQueries extends SQLiteOpenHelper {

    String TAG = "";

    public DBQueries(Context context) {
        super(context, "ContactsDB", null, 1);
        Log.d(TAG, "DataBaseCreated");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SqlTableQuery = "CREATE TABLE CONTACTS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstName TEXT," +
                "lastName TEXT," +
                "phoneNumber TEXT," +
                "emailAddress TEXT," +
                "homeAddress TEXT)";
        sqLiteDatabase.execSQL(SqlTableQuery);

        Log.d("TAG", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void InsertSingleContact(HashMap<String, String> contact) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id", contact.get("_id"));
        contentValues.put("firstName", contact.get("firstName"));
        contentValues.put("lastName", contact.get("lastName"));
        contentValues.put("phoneNumber", contact.get("phoneNumber"));
        contentValues.put("emailAddress", contact.get("emailAddress"));
        contentValues.put("homeAddress", contact.get("homeAddress"));

        long result = db.insert("CONTACTS", null, contentValues);


        if (result != -1) {
            Log.d("TAG", "new Contact Inserted" + result);

        } else {
            Log.d("TAG", "new Contact Insertion Failed" + result);

        }
    }

//Fetch Data from DB

    public ArrayList<HashMap<String, String>> getAllContacts() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String, String>> contactlist =
                new ArrayList<HashMap<String, String>>();

        String Query = "SELECT * FROM CONTACTS";
        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("_id", cursor.getString(0));
                hashMap.put("firstName", cursor.getString(1));
                hashMap.put("lastName", cursor.getString(2));
                hashMap.put("phoneNumber", cursor.getString(3));
                hashMap.put("emailAddress", cursor.getString(4));
                hashMap.put("homeAddress", cursor.getString(5));

                contactlist.add(hashMap);


            } while (cursor.moveToNext());
        }
        return contactlist;
    }

    public HashMap<String, String> getSingleContact(String id) {
        SQLiteDatabase db = getReadableDatabase();
        //HashMap<String,String> singleRecord = new HashMap<String,String>();


        String Query = "SELECT * FROM CONTACTS WHERE _id=" + id;


        Cursor cursor = db.rawQuery(Query, null);

        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (cursor.moveToFirst()) {


            hashMap.put("_id", cursor.getString(0));
            hashMap.put("firstName", cursor.getString(1));
            hashMap.put("lastName", cursor.getString(2));
            hashMap.put("phoneNumber", cursor.getString(3));
            hashMap.put("emailAddress", cursor.getString(4));
            hashMap.put("homeAddress", cursor.getString(5));


        }
        return hashMap;
    }
}
