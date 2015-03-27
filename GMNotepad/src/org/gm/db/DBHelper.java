package org.gm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "notepad.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "items";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// _id, title, created_timestamp, updated_timestamp, content,
		// image_urls, media_urls
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
				+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Title TEXT,"
				+ "CreatedTimestamp VARCHAR(12), "
				+ "UpdatedTimestamp VARCHAR(12), " + "Content TEXT, "
				+ "ImageUrls TEXT, " + "MediaUrls TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN other STRING");
	}

}
