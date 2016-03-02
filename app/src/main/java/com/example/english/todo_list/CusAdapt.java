package com.example.english.todo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CusAdapt extends BaseAdapter {

    Context context;
    String[] data;
    ArrayList<String> lsts;
    private static LayoutInflater inflater = null;

    public CusAdapt(Context context, String[] data, ArrayList<String> ls) {
        this.context = context;
        this.data = data;
        this.lsts = ls;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(String s){
        lsts.add(s);
    }

    @Override
    public int getCount() {
        return lsts.size();
    }

    @Override
    public Object getItem(int position) {
        return lsts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.items, null);
        TextView text = (TextView) vi.findViewById(R.id.textList);
        text.setText(lsts.get(position));
        return vi;
    }
}