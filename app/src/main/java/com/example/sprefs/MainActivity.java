package com.example.sprefs;

import static android.provider.Telephony.BaseMmsColumns.MESSAGE_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_ID = "messages_prefs";
    private Button saveButton;
    private EditText enterMessage;
    private TextView showMessageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.button);
        enterMessage = findViewById(R.id.message_edittext);
        showMessageTextView = findViewById(R.id.showtext);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = enterMessage.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
                // here it is nested class  called  SharedPreferences.Editor
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message", message);
                editor.apply(); // saving to Disk !


            }
        });


        // Get data from SP
        SharedPreferences getSharedPrefs  = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getSharedPrefs.getString("message", "nothing");
        showMessageTextView.setText(value);
    }
}