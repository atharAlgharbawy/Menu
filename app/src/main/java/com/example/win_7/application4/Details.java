package com.example.win_7.application4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tv_name = (TextView)findViewById(R.id.tv_namee);
        //tv_name.setText("");


    }//on create


}//class
