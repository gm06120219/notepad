package org.gm.process;

import java.util.ArrayList;

import org.gm.db.DBManager;
import org.gm.db.NoteAtom;
import org.gm.ui.EditActivity;

import android.content.Context;
import android.text.InputType;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;

public class NoteEditView extends LinearLayout {

	private Context context;
	EditText etTitle;
	EditText etContent;
	int id;
	DBManager db;
	private Button btnSave;

	public NoteEditView(Context context, DBManager db) {
		super(context);
		this.context = context;
		this.db = db;
		this.setOrientation(LinearLayout.VERTICAL);
		EditText etTitle = new EditText(this.context);
		etTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		etTitle.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
				| InputType.TYPE_CLASS_TEXT);
		EditText etContent = new EditText(this.context);
		etContent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		// etContent.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
		// | InputType.TYPE_CLASS_TEXT);

		this.addView(etTitle);
		this.addView(etContent);
		this.etTitle = etTitle;
		this.etContent = etContent;

		this.btnSave = new Button(this.context);
		btnSave.setText("Save");
		btnSave.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		this.addView(btnSave);
		
	}

	public void SetTitle(String title) {
		this.etTitle.setText(title);
	}

	public void SetContent(String content) {
		this.etContent.setText(content);
	}

	public void SetId(int id) {
		this.id = id;
	}
	
	public void SetSaveListener(OnClickListener listener){
		this.btnSave.setOnClickListener(listener);
	}

	public void save() {
		if (this.id > 0) {
			NoteAtom na = this.db.find(id);
			na.title = this.etTitle.getText().toString();
			na.content = this.etContent.getText().toString();
			this.db.update(na);
			Log.i("gm", "update");
		} else {
			NoteAtom na = new NoteAtom(this.etTitle.getText()
					.toString(), this.etContent.getText().toString(),
					null, null);
			ArrayList<NoteAtom> list = new ArrayList<NoteAtom>();
			list.add(na);
			this.db.add(list);
			Log.i("gm", "add");
		}
	}

	

}
