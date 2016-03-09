package com.example.english.todo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CusAdapt extends BaseAdapter {

    Context context;
    String[] data;
    ArrayList<String> lsts;
    private static LayoutInflater inflater = null;
    ArrayList<ToDoItems> items = new ArrayList<ToDoItems>();

    public CusAdapt(Context context, String[] data, ArrayList<String> ls) {
        this.context = context;
        this.data = data;
        this.lsts = ls;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void add(String s){
        items.add(new ToDoItems(s, false));
        lsts.add(s);
    }

    public void delete(int position){
        items.remove(position);
        lsts.remove(position);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolderItem viewHolder;

        if(convertView==null){

            Context context = parent.getContext();
            convertView = LayoutInflater.from(context).inflate(R.layout.items, null);
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.textList);
            viewHolder.checkboxItem = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolderItem) convertView.getTag();
        }
        viewHolder.checkboxItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               items.get(position).setChecked(isChecked);
            }
        });
        viewHolder.checkboxItem.setChecked(items.get(position).getChecked());
        viewHolder.textViewItem.setText(items.get(position).getText());
        return convertView;
    }

    static class ViewHolderItem {
        TextView textViewItem;
        CheckBox checkboxItem;
    }

    public ArrayList<ToDoItems> getToDoItems()
    {
        return items;
    }
}