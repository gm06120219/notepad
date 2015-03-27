//package org.gm.ui;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.gm.db.Atom;
//import org.gm.db.DBManager;
//import org.gm.gmnotepad.R;
//import org.gm.gmnotepad.R.id;
//import org.gm.gmnotepad.R.layout;
//import org.gm.gmnotepad.R.menu;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//public class xActivity extends Activity implements OnClickListener {
//
//	private DBManager mgr;
//	private ListView lv;
//	private Button btnAdd;
//	private Button btnUpdate;
//	private Button btnDelete;
//	private Button btnQuery;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		mgr = new DBManager(this);
//
//		lv = (ListView) findViewById(R.id.lv);
//		btnAdd = (Button) findViewById(R.id.btnAdd);
//		btnAdd.setOnClickListener(this);
//		btnUpdate = (Button) findViewById(R.id.btnUpdate);
//		btnUpdate.setOnClickListener(this);
//		btnDelete = (Button) findViewById(R.id.btnDelete);
//		btnDelete.setOnClickListener(this);
//		btnQuery = (Button) findViewById(R.id.btnQuery);
//		btnQuery.setOnClickListener(this);
//
//	}
//
//	public void Add() {
//		ArrayList<Atom> items = new ArrayList<Atom>();
//
//		items.add(new Atom("item1", "item1", null, null));
//		items.add(new Atom("item2", "item2", null, null));
//		items.add(new Atom("item3", "item3", null, null));
//
//		mgr.add(items);
//	}
//
//	public void Delete() {
//		Atom item = new Atom();
//		item.id = 1;
//		mgr.delete(item);
//	}
//
//	public void Update() {
//		Atom item = new Atom();
//		item.id = 3;
//		item.title = "item3 update";
//		item.content = "item3 update";
//		mgr.update(item);
//	}
//
//	private void Query() {
//		List<Atom> items = mgr.query();
//
//		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
//		for (Atom item : items) {
//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("title", item.title);
//			map.put("content", item.content);
//			list.add(map);
//		}
//		SimpleAdapter adapter = new SimpleAdapter(this, list,
//				android.R.layout.simple_list_item_2, new String[] { "title",
//						"content" }, new int[] { android.R.id.text1,
//						android.R.id.text2 });
//		lv.setAdapter(adapter);
//	}
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.btnAdd:
//			Add();
//			break;
//		case R.id.btnUpdate:
//			Update();
//			break;
//		case R.id.btnDelete:
//			Delete();
//			break;
//		case R.id.btnQuery:
//			Query();
//			break;
//		default:
//			break;
//		}
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//
//}
