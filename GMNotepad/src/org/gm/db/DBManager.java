package org.gm.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {

	private DBHelper helper;
	private SQLiteDatabase db;
	private Context context;

	public DBManager(Context context) {
		this.context = context;
		helper = new DBHelper(this.context);
		db = helper.getWritableDatabase();
	}

	/**
	 * add items
	 * 
	 * @param List
	 *            <NoteItem>
	 */
	public void add(List<NoteAtom> items) {
		if (items == null) {
			return;
		}

		db.beginTransaction(); // 开始事务
		try {
			for (NoteAtom item : items) {
				ContentValues values = new ContentValues();
				values.put("Title", item.title);
				values.put("CreatedTimestamp", item.createdTimestamp);
				values.put("UpdatedTimestamp", item.updatedTimestamp);
				values.put("Content", item.content);
				values.put("ImageUrls", item.imageUrls);
				values.put("MediaUrls", item.mediaUrls);
				db.insert(DBHelper.TABLE_NAME, null, values);
			}
			db.setTransactionSuccessful(); // 设置事务成功完成
		} catch (Exception e) {
			Log.e("gm", e.toString());
		} finally {
			db.endTransaction(); // 结束事务
		}
	}

	public NoteAtom find(int id) {
		NoteAtom atom = null;
		if (id > 0) {
			String sql = "select * from " + DBHelper.TABLE_NAME + " where id="
					+ id + ";";
			Cursor c = db.rawQuery(sql, null);
			while (c.moveToNext()) {
				atom = new NoteAtom(id, c.getString(c.getColumnIndex("Title")),
						c.getString(c.getColumnIndex("Content")), c.getString(c
								.getColumnIndex("ImageUrls")), c.getString(c
								.getColumnIndex("MediaUrls")), c.getLong(c
								.getColumnIndex("CreatedTimestamp")),
						c.getLong(c.getColumnIndex("UpdatedTimestamp")));
			}
			return atom;
		}
		return null;
	}

	/**
	 * update item
	 * 
	 * @param NoteAtom
	 */
	public void update(NoteAtom item) {
		if (item == null) {
			return;
		}

		// initialization time stamp
		item.updatedTimestamp = (int) (System.currentTimeMillis() / 1000);

		ContentValues cv = new ContentValues();
		cv.put("title", item.title);
		cv.put("createdTimestamp", item.createdTimestamp);
		cv.put("updatedTimestamp", item.updatedTimestamp);
		cv.put("content", item.content);
		cv.put("imageUrls", item.imageUrls);
		cv.put("mediaUrls", item.mediaUrls);

		db.update(DBHelper.TABLE_NAME, cv, "id = ?",
				new String[] { String.valueOf(item.id) });
	}

	/**
	 * delete item
	 * 
	 * @param NoteAtom
	 */
	public void delete(NoteAtom item) {
		if (item == null) {
			return;
		}
		db.delete(DBHelper.TABLE_NAME, "id = ?",
				new String[] { String.valueOf(item.id) });
	}

	/**
	 * query all items, return list
	 * 
	 * @return List<NoteItem>
	 */
	public List<NoteAtom> query() {
		ArrayList<NoteAtom> items = new ArrayList<NoteAtom>();

		Cursor c = queryTheCursor();
		if (c == null) {
			return null;
		}

		while (c.moveToNext()) {
			int id = c.getInt(c.getColumnIndex("Id"));
			String title = c.getString(c.getColumnIndex("Title"));
			String content = c.getString(c.getColumnIndex("Content"));
			String image = c.getString(c.getColumnIndex("ImageUrls"));
			String media = c.getString(c.getColumnIndex("MediaUrls"));
			long create = c.getLong(c.getColumnIndex("CreatedTimestamp"));
			long update = c.getLong(c.getColumnIndex("CreatedTimestamp"));
			NoteAtom item = new NoteAtom(id, title, content, image, media,
					create, update);
//			Log.i("gm", id + "|" + title + "|" + content + "|" + image + "|"
//					+ media + "|" + create + "|" + update);

			items.add(item);
		}
		c.close();

		return items;
	}

	/**
	 * query all items, return cursor
	 * 
	 * @return Cursor
	 */
	public Cursor queryTheCursor() {
		Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME + ";",
				null);
		return c;
	}

	/**
	 * close database
	 */
	public void closeDB() {
		db.close();
	}
}
