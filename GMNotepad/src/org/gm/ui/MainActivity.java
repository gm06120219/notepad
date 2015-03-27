package org.gm.ui;

import org.gm.db.DBManager;
import org.gm.gmnotepad.R;
import org.gm.process.NoteListView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	public static DBManager db;
	private NoteListView nlv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		db = new DBManager(this);

		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);

		nlv = new NoteListView(this, db);
		ll.addView(nlv);

		Button btn = new Button(this);
		btn.setText("Add");
		btn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				android.widget.AbsListView.LayoutParams.WRAP_CONTENT));

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putInt("id", 0);
				Intent intent = new Intent(MainActivity.this, EditActivity.class);
				intent.putExtras(bundle);
				MainActivity.this.startActivity(intent);
			}
		});
		ll.addView(btn);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("gm", "main activity resume");
		nlv.refresh();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("gm", "main activity stop");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
