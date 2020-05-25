package com.example.checkbox;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends BaseAdapter {


    List<Data> dataList;
    Context context;
    MainActivity mainActivity;
     int sumPrice = 0;
    public PhoneAdapter(List<Data> dataList, Context context, MainActivity mainActivity) {
        this.dataList = dataList;
        this.context = context;
        this.mainActivity = mainActivity;
    }


    public void UpdateView(List<Data> dataArrayList){
        this.dataList = dataArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.data, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Data data = (Data) getItem(position);
        viewHolder.tvNamePhone.setText(data.getNamePhone());
        viewHolder.tvPrice.setText(data.getPrice() + " vnđ");
        viewHolder.img.setImageResource(data.img);

        final TextView tvPrice = mainActivity.findViewById(R.id.tvprice);


        viewHolder.line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.checkBox.setChecked(!viewHolder.checkBox.isChecked());
                if(viewHolder.checkBox.isChecked()) {
                    viewHolder.checkBox.setChecked(false);
                }
                else {
                    viewHolder.checkBox.setChecked(true);
                }
            }
        });
        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    sumPrice += (Integer.parseInt(data.getPrice()));
                    tvPrice.setText(String.valueOf(sumPrice) +" vnđ");
                }else {
                    sumPrice -= (Integer.parseInt(data.getPrice()));
                    tvPrice.setText(String.valueOf(sumPrice +" vnđ"));
                }
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvNamePhone,tvPrice;
        ImageView img;
        CheckBox checkBox;
        LinearLayout line1;
        public ViewHolder(View view) {
            tvNamePhone = (TextView)view.findViewById(R.id.tvNamePhone);
            tvPrice = view.findViewById(R.id.tvPrice);
            checkBox = view.findViewById(R.id.cbChoose);
            img = view.findViewById(R.id.imgPhone);
            line1 = view.findViewById(R.id.line1);
        }
    }
}
