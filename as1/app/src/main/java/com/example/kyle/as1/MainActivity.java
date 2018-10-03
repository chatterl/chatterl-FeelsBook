package com.example.kyle.as1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "data.sav";
    ArrayList<EmotionData> oldEmotions = new ArrayList<EmotionData>();
    ArrayList<EmotionData> newEmotions = new ArrayList<EmotionData>();
    ArrayList<ArrayList<EmotionData>> finalEmotions = new ArrayList<ArrayList<EmotionData>>();

    private int loveCounter = 0;
    TextView lovetxv;
    private int joyCounter = 0;
    TextView joytxt;
    private int surpriseCounter = 0;
    TextView surprisetxt;
    private int angerCounter = 0;
    TextView angertxt;
    private int fearCounter = 0;
    TextView feartxt;
    private int sadnessCounter = 0;
    TextView sadnesstxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LOVE Button Code
        Button love = (Button) findViewById(R.id.love);
        lovetxv = (TextView) findViewById(R.id.loveCount);
        // this listens for when the love button is clicked
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "Love";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update the counter
                loveCounter++;
                lovetxv.setText(Integer.toString(loveCounter));
            }
        });

        // JOY Button Code
        Button joy = (Button) findViewById(R.id.joy);
        joytxt = (TextView) findViewById(R.id.joyCount);
        // this listens for when the joy button is clicked
        joy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "Joy";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update the counter
                joyCounter++;
                joytxt.setText(Integer.toString(joyCounter));

            }
        });

        // SURPRISE Button Code
        Button surprise = (Button) findViewById(R.id.surprise);
        surprisetxt = (TextView) findViewById(R.id.surpriseCount);
        // this listens for when the surprise button is clicked
        surprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "surprise";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update the counter
                surpriseCounter++;
                surprisetxt.setText(Integer.toString(surpriseCounter));

            }
        });

        // ANGER Button Code
        Button anger = (Button) findViewById(R.id.anger);
        angertxt = (TextView) findViewById(R.id.angerCount);
        // this listens for when the anger button is clicked
        anger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "Anger";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update counter
                angerCounter++;
                angertxt.setText(Integer.toString(angerCounter));

            }
        });

        // SADNESS Button Code
        Button sadness = (Button) findViewById(R.id.sadness);
        sadnesstxt = (TextView) findViewById(R.id.sadnessCount);
        // this listens for when the sadness button is clicked
        sadness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "Sadness";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update counter
                sadnessCounter++;
                sadnesstxt.setText(Integer.toString(sadnessCounter));

            }
        });

        // FEAR Button Code
        Button fear = (Button) findViewById(R.id.fear);
        feartxt = (TextView) findViewById(R.id.fearCount);
        // this listens for when the fear button is clicked
        fear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotionData temp_emotion = new EmotionData();   // create new object of emotionData type
                temp_emotion.emotion = "Fear";

                //get date and time
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                temp_emotion.savedTime = date;

                //get and save users comment
                EditText editText = (EditText) findViewById(R.id.commentBox);
                String message = editText.getText().toString();
                temp_emotion.comment = message;

                // save temp_emotion data  into a list
                newEmotions.add(temp_emotion);

                // save temp_emotion data  into a file
                SaveInFile(temp_emotion);

                //update counter
                fearCounter++;
                feartxt.setText(Integer.toString(fearCounter));

            }
        });

        // HISTORY Button Code
        Button history = (Button) findViewById(R.id.history);
        // this listens for when the love button is clicked
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // load old emotions
                //    loadFromFile();
                //take user to history screen
                //finalEmotions.add(oldEmotions);
                //finalEmotions.add(newEmotions);
                Intent startIntent = new Intent(getApplicationContext(), historyActivity.class);
                //To pass:
                startIntent.putExtra("oldEmotions", newEmotions);

                //Intent i = new Intent();
                //i.putExtra("name_of_extra", myParcelableObject);
                startActivity(startIntent);
            }
        });
    }

    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson(); // library to save new objects
            Type listType = new TypeToken<ArrayList<EmotionData>>(){}.getType();

            oldEmotions = gson.fromJson(in, listType);


        } catch (FileNotFoundException e) {
            newEmotions = new ArrayList<EmotionData>();
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return tweets.toArray(new String[tweets.size()]);
    }

    private void SaveInFile(EmotionData temp_emotion) {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_APPEND);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(newEmotions, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


