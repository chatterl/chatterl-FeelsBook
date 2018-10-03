package com.example.kyle.as1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class historyActivity extends AppCompatActivity {
    //private ListView lv;
    //ArrayAdapter<EmotionData> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView lv = (ListView) findViewById(R.id.hisLis);

        // To retrieve object in second Activity
        ArrayList<EmotionData> oldEmotions = (ArrayList<EmotionData>) getIntent().getSerializableExtra("oldEmotions");
        //Toast toast = Toast.makeText(this, oldEmotions.get(0).getEmotion() , Toast.LENGTH_SHORT); toast.show();

        //ArrayAdapter<EmotionData> adapter = new ArrayAdapter<EmotionData>(this,android.R.layout.simple_list_item_1, oldEmotions);

        ArrayList<String> temp_array = new ArrayList<String>();
        for (EmotionData temp : oldEmotions) {

            String temp_date = String.valueOf(temp.getSavedTime());
            String temp_list_value = "EMOTION: " + temp.getEmotion() + "\nRECORDED: " + temp_date + "\nCOMMENT: " + temp.getComment();
            temp_array.add(temp_list_value);


        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp_array);

        lv.setAdapter(adapter);

    }
}


