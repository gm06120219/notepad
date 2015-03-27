package org.gm.process;

import org.gm.ui.SwitchDpPx;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteItemView extends LinearLayout {

	TextView tvDate = null;
	TextView tvTitle = null;
	TextView tvContent = null;
	ImageView ivPreview = null;
	Context context = null;

	public NoteItemView(Context context) {
		super(context);
		this.context = context;
		this.setOrientation(LinearLayout.VERTICAL);

		initDate();
		initTitle();
		initContent();

		this.addView(getDate());
		this.addView(getTitle());
		this.addView(getContent());
	}

	private void initDate() {
		this.tvDate = new TextView(this.context);
		this.tvDate.setWidth(SwitchDpPx.dip2px(this.context, 200));
		this.tvDate.setHeight(SwitchDpPx.dip2px(this.context, 20));
		this.tvDate.setPadding(SwitchDpPx.dip2px(this.context, 15), 0, 0, 0);
		this.tvDate.setTextColor(0xFF33CC66);
		this.tvDate.setTextSize(14);
	}

	private void initTitle() {
		this.tvTitle = new TextView(this.context);
		this.tvTitle.setWidth(SwitchDpPx.dip2px(this.context, 200));
		this.tvTitle.setHeight(SwitchDpPx.dip2px(this.context, 30));
		this.tvTitle.setPadding(SwitchDpPx.dip2px(this.context, 30), 0, 0, 0);
		this.tvTitle.setTextColor(0xFF000000);
		this.tvTitle.setTextSize(20);
	}

	private void initContent() {
		this.tvContent = new TextView(this.context);
		this.tvContent.setWidth(SwitchDpPx.dip2px(this.context, 200));
		this.tvContent.setHeight(SwitchDpPx.dip2px(this.context, 25));
		this.tvContent.setPadding(SwitchDpPx.dip2px(this.context, 20), 0, 0, 0);
		this.tvContent.setTextColor(0xFF0099CC);
	}

	public TextView getDate() {
		if (this.tvDate == null) {
			initDate();
		}
		return this.tvDate;
	}

	public TextView getTitle() {
		if (this.tvTitle == null) {
			initTitle();
		}

		return this.tvTitle;
	}

	public TextView getContent() {
		if (this.tvContent == null) {
			initContent();
		}

		return this.tvContent;
	}

	public void SetDateValue(String date) {
		getDate().setText(date);
	}

	public void SetTitleValue(String title) {
		getTitle().setText(title);
	}

	public void SetContentValue(String content) {
		getContent().setText(content);
	}

	public void SetImageValue(Bitmap bitmap) {
		// TODO image note
	}

	public void SetItemColor(int color) {
		this.setBackgroundColor(color);
	}
}
