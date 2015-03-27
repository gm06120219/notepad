package org.gm.process;

import java.util.List;

import org.gm.db.DBManager;
import org.gm.db.NoteAtom;
import org.gm.ui.EditActivity;
import org.gm.ui.SwitchDpPx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NoteListView extends ListView implements OnItemClickListener {
	Context context;
	NoteAdapter adapter;
	DBManager db;
	List<NoteAtom> content;

	public NoteListView(Context context, DBManager db) {
		super(context);
		this.context = context;

		this.db = db;
		content = db.query();
		adapter = new NoteAdapter(this.context, content);
		this.setAdapter(adapter);
		this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				SwitchDpPx.dip2px(this.context, 360)));

		this.setOnItemClickListener(this);
	}
	
	public void refresh(){
		content = db.query();
		adapter.refresh(content);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		NoteAtom atom = (NoteAtom) this.getItemAtPosition(position);
		Log.i("gm", "edit view transfer id " + atom.id);
		Bundle bundle = new Bundle();
		bundle.putInt("id", atom.id);
		bundle.putString("title", atom.title);
		bundle.putString("content", atom.content);

		Intent intent = new Intent(this.context, EditActivity.class);
		intent.putExtras(bundle);

		this.context.startActivity(intent);
	}
	
	// TODO swipe left to display delete button
}
