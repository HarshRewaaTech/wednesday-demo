package com.harsh.wednesdayDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView mExpandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    ListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize view
        initView();
    }

    private void initView(){
        mExpandableListView=(ExpandableListView) findViewById(R.id.mListExp);
        //Prepare List Data
        prepareListData();
        listItemAdapter=new ListItemAdapter(this,listDataHeader,listDataChild);
        //Setting list Adapter
        mExpandableListView.setAdapter(listItemAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Alphabets");
        listDataHeader.add("Numbers");

        List<String> alphabetsList=new ArrayList<String>();
        alphabetsList.add("A");
        alphabetsList.add("B");
        alphabetsList.add("C");
        alphabetsList.add("D");
        alphabetsList.add("E");

        List<String> numberList=new ArrayList<String>();
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");
        numberList.add("5");

        listDataChild.put(listDataHeader.get(0),alphabetsList);
        listDataChild.put(listDataHeader.get(1),numberList);
    }
}