package com.example.sql_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {
    Database database;

    public DatabaseAdapter(Context context) {
        database = new Database(context);
    }

    public long insertData(String name, String phnumber) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.USER_NAME, name);
        contentValues.put(Database.USER_NUMBER, phnumber);
        long id = db.insert(Database.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase db = database.getWritableDatabase();
        String[] columns = {Database.USER_ID, Database.USER_NAME, Database.USER_NUMBER};
        Cursor cursor = db.query(Database.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(Database.USER_ID);
            int userId = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(Database.USER_NAME);
            String userName = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(Database.USER_NUMBER);
            String userPhonenumber = cursor.getString(index3);
            buffer.append(userId + ".     " + userName + "     " + userPhonenumber + "\n");
        }
        return buffer.toString();
    }

    static class Database extends SQLiteOpenHelper {
        private static final String DB_NAME = "Userinfo";
        private static final String TABLE_NAME = "USERTABLE";
        private static final int DB_VERSION = 1;
        private static final String USER_ID = "_ID";
        private static final String USER_NAME = "USERNAME";
        private static final String USER_NUMBER = "PHONENUMBER";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " VARCHAR(255), " + USER_NUMBER + " VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private final Context context;

        public Database(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
