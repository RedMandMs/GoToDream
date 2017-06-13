package com.happyhamster.soft.gotodream.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happyhamster.soft.gotodream.R;
import com.happyhamster.soft.gotodream.domain.entity.Dream;

import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */

public class DreamAdapter  extends BaseAdapter{

    private List<Dream> dreams;
    private LayoutInflater layoutinflater;
    private Context context;

    public DreamAdapter(List<Dream> dreams, LayoutInflater layoutinflater, Context context) {
        this.dreams = dreams;
        this.layoutinflater = layoutinflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dreams.size();
    }

    @Override
    public Object getItem(int position) {
        return dreams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dreams.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.listview_dream_item, parent, false);
            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.dreamImage);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textInListView.setText(dreams.get(position).getName());
        int imageResourceId = this.context.getResources().getIdentifier(dreams.get(position).getImageResource(), "drawable", this.context.getPackageName());
        listViewHolder.imageInListView.setImageResource(imageResourceId);

        return convertView;
    }

    private static class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
    }
}
