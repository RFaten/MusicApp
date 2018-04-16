package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the button view that starts activity_music
        Button start_music_button = (Button) findViewById(R.id.start_music_button);
        // Set a clickListener on that view
        start_music_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open {@link MusicActivity}
                Intent musicIntent = new Intent(MainActivity.this, MusicActivity.class);
                // Start the new activity
                startActivity(musicIntent);
            }
        });
    }
}
