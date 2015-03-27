package org.gm.process;

import java.util.List;

import org.gm.db.NoteAtom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter {
	private Context context;
	List<NoteAtom> atoms;

	public final class ViewHolder {
		public TextView tvTitle;
		public TextView tvContent;
	}

	public NoteAdapter(Context context, List<NoteAtom> atoms) {
		this.context = context;
		this.atoms = atoms;
	}

	@Override
	public int getCount() {
		return atoms.size();
	}

	@Override
	public Object getItem(int position) {
		return atoms.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public void refresh(List<NoteAtom> atoms) {
		this.atoms = atoms;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if (convertView == null) {
			convertView = new NoteItemView(this.context);
			holder = new Holder();
			holder.tvDate = ((NoteItemView) convertView).getDate();
			holder.tvTitle = ((NoteItemView) convertView).getTitle();
			holder.tvContent = ((NoteItemView) convertView).getContent();
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		long timestamp = atoms.get(position).updatedTimestamp;
		holder.tvDate.setText(TimeTools.Convert(timestamp));
		holder.tvTitle.setText(atoms.get(position).title);
		holder.tvContent.setText(atoms.get(position).content);

		return convertView;
	}

	class Holder {
		private TextView tvDate, tvTitle, tvContent;
	}

}
