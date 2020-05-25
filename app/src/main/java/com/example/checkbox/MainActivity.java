package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView lvData;
    TextView tvPrice;
    List<Data> dataList;
    PhoneAdapter phoneAdapter;

    PhoneAdapter.ViewHolder viewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvData = findViewById(R.id.lvData);
        tvPrice = findViewById(R.id.tvprice);
        dataList = new ArrayList<>();
        dataList.add(new Data("Iphone 11pro max","15",R.drawable.iphone11,false));
        dataList.add(new Data("Samsung Galaxy S20 Ultra","20",R.drawable.samsung,false));
        phoneAdapter = new PhoneAdapter(dataList, this,this);
        lvData.setAdapter(phoneAdapter);

    }

}
