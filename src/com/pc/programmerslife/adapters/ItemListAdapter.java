package com.pc.programmerslife.adapters;

import java.util.List;

import com.pc.framework.rss.Item;
import com.pc.programmerslife.Manager;
import com.pc.programmerslife.R;
import com.pc.programmerslife.views.PreviewView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ItemListAdapter extends ArrayAdapter<Item> {
	private LayoutInflater inflater;
	private Manager manager;

	public ItemListAdapter(Context context, int textViewResourceId, List<Item> objects) {
		super(context, textViewResourceId, objects);
		inflater = LayoutInflater.from(context);
		manager = Manager.getInstance();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.item_list_layout, parent, false);
		
		Item item = getItem(position);
		
		String commicPath = manager.getCommicPath(item.getContent());
		
		PreviewView previewView = (PreviewView) convertView.findViewById(R.id.itemListLayout_previewView);
		previewView.drawText(manager.getCommicNumber(commicPath));
		
		TextView textViewTitle = (TextView) convertView.findViewById(R.id.itemListLayout_textView_title);
		textViewTitle.setText(item.getTitle());
		
		return convertView;
	}
}