package com.example.english.todo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
        //items.add(new ToDoItems("Exemple",0));
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
    public View getView(int position, View convertView, ViewGroup parent) {
        /*View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.items, null);
        TextView text = (TextView) vi.findViewById(R.id.textList);
        if(items.size() != 0) {
            text.setText(items.get(position).getText());
        }*/

        ViewHolderItem viewHolder;

        if(convertView==null){

            // inflate the layout
            Context context = parent.getContext();
            convertView = LayoutInflater.from(context).inflate(R.layout.items, null);
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.textList);
            viewHolder.checkboxItem = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolderItem) convertView.getTag();
        }
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