package com.example.android.musicapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Song song = (Song) getIntent().getSerializableExtra("songs_list");
        int imageResourceId = song.getImageResourceId();
        String songName = song.getSongTitle();
        String singerName = song.getSinger();

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(imageResourceId);

        TextView songTitle = (TextView) findViewById(R.id.song_title);
        songTitle.setText(songName);

        TextView singer = (TextView) findViewById(R.id.singer);
        singer.setText(singerName);
    }
}
