package com.example.technicaltest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.example.technicaltest.Adapter.ListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    private AppCompatImageView BtnCarou;
    private FloatingActionButton fab;
    private int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.ExList);
        initData();
        listAdapter=new ListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
        BtnCarou=findViewById(R.id.BtnCarousell);

        fab=findViewById(R.id.fab);

        BtnCarou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BannerActivity.class);
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
    }

    private void AddData(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Add Data");

        LayoutInflater inflater = LayoutInflater.from(this);
        final View AddData = inflater.inflate(R.layout.layout_add,null);

        final EditText txtTitle = AddData.findViewById(R.id.txtTitle);
        final EditText txtItem = AddData.findViewById(R.id.txtItem);

        dialog.setView(AddData);

        dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                int i = listDataHeader.size();
                listDataHeader.add(txtTitle.getText().toString());
//                String var = "aaa"+i;
                List<String> var=new ArrayList<>();
                var.add(txtItem.getText().toString());
                listHash.put(listDataHeader.get(i),var);
                Log.d("Indexnya",String.valueOf(i));
                i=i+1;
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    private void initData(){
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("AAAA");
        listDataHeader.add("AAAb");
        listDataHeader.add("AAAc");
        listDataHeader.add("AAAd");

        y=listDataHeader.size();

        List<String> aaa= new ArrayList<>();
        aaa.add("This aaa");

        List<String> bbb= new ArrayList<>();
        bbb.add("This aab");

        List<String> ccc= new ArrayList<>();
        ccc.add("This cac");

        List<String> ddd= new ArrayList<>();
        ddd.add("This dad");

        listHash.put(listDataHeader.get(0),aaa);
        listHash.put(listDataHeader.get(1),bbb);
        listHash.put(listDataHeader.get(2),ccc);
        listHash.put(listDataHeader.get(3),ddd);
    }
}
