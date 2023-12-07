package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpaceImageDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SpaceImagesDB";
    private static final int VERSION_NUM = 1;
    public static final String TABLE_NAME = "SpaceImages";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_DATE = "date";
    public static final String COL_IMAGE_URL = "image_url";
    public static final String COL_DESCRIPTION = "description";

    public SpaceImageDbHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_DATE + " TEXT, " +
                COL_IMAGE_URL + " TEXT, " +
                COL_DESCRIPTION + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}