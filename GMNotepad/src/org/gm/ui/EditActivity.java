package org.gm.ui;

import org.gm.process.NoteEditView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class EditActivity extends Activity {
	private NoteEditView nev;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.nev = initView();
		setContentView(nev);
	}

	private NoteEditView initView() {
		this.nev = new NoteEditView(this, MainActivity.db);

		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		int id = bundle.getInt("id");
		String title = bundle.getString("title");
		String content = bundle.getString("content");
		Log.i("gm", "edit view accept id " + id);

		if (id != 0) {
			this.nev.SetTitle(title);
			this.nev.SetContent(content);
		}
		this.nev.SetId(id);

		this.nev.SetSaveListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				nev.save();
				EditActivity.this.finish();
			}
		});

		return nev;
	}
}
