package com.harsh.wednesdayDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ListItemAdapter extends BaseExpandableListAdapter {
    Context mContext;
    List<String> headerString;
    HashMap<String,List<String>> childList;

    public ListItemAdapter(Context mContext, List<String> headerString, HashMap<String, List<String>> childList) {
        this.mContext = mContext;
        this.headerString = headerString;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return this.headerString.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(this.headerString.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headerString.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.childList.get(this.headerString.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle=(String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_header_item,null);
        }
        TextView lblHeader=(TextView)convertView.findViewById(R.id.headerItem);
        lblHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
     final String childText=(String)getChild(groupPosition,childPosition);
     if(convertView==null){
         LayoutInflater inflater=(LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView=inflater.inflate(R.layout.custom_child_item,null);
     }
        TextView txtChild=(TextView)convertView.findViewById(R.id.txtChild);
        txtChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
