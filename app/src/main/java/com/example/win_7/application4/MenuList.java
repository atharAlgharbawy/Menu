package com.example.win_7.application4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuList extends AppCompatActivity {

    ListView list;
    String[] menu_name;
    String[] menu_price;
    int[] menu_pic = {R.drawable.cream_cheese, R.drawable.frozen_cramel,R.drawable.chocolate_browni,
             R.drawable.cheescake, R.drawable.chocolate_cack , R.drawable.waffle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        Resources res = getResources();
        menu_name = res.getStringArray(R.array.dessertName);
        menu_price = res.getStringArray(R.array.dessertPrice);


        list=(ListView)findViewById(R.id.myLiist);
        final myAdapter adapter = new myAdapter(this, menu_name , menu_pic , menu_price);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MenuList.this, Details.class);
                //String each = adapter.getItem(position);
                //i.putExtra("eachItem", each);
                startActivity(i);

            }
        });



    }//on create
}//first class






class myAdapter extends ArrayAdapter<String>{
    Context context;
    int[] imgArray;
    String[] namesArray;
    String[] priceArray;

    public myAdapter(Context c, String[] namm, int[] img , String[] prices) {
        super(c, R.layout.row, R.id.tv_price, namm);
        this.context = c;
        this.imgArray=img;
        this.namesArray=namm;
        this.priceArray=prices;
    }//constructor

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roow = inflater.inflate(R.layout.row, parent, false);

        ImageView myImage = (ImageView) roow.findViewById(R.id.pic);
        TextView my_name = (TextView) roow.findViewById(R.id.tv_namee);
        TextView my_price = (TextView) roow.findViewById(R.id.tv_price);

        myImage.setImageResource(imgArray[position]);
        my_name.setText(namesArray[position]);
        my_price.setText(priceArray[position]);

        return roow;
    }
}//second class
