package com.example.android.musicapp;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static android.os.Build.VERSION_CODES.M;

public class MusicActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SongAdapter adapter;
    ArrayList<Song> songs;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_music.xml layout file
        setContentView(R.layout.activity_music);

        songs = new ArrayList<>();
        songs.add(new Song("4 Minutes", "Madonna & Justin Timberlake", R.drawable.four_minutes));
        songs.add(new Song("Aman Aman", "Linet", R.drawable.aman_aman));
        songs.add(new Song("Asmar Ya Amarany", "Abdel Halim Hafez", R.drawable.asmar_ya_asmarany));
        songs.add(new Song("Daydream", "Wallace collection", R.drawable.daydream));
        songs.add(new Song("Eksik", "Mustafa Ceceli & Elvan Günaydın", R.drawable.eksik));
        songs.add(new Song("Odet Enie", "Om Kalsoum", R.drawable.odet_enie));
        songs.add(new Song("Rolling in The Deep", "Adele", R.drawable.rolling_in_the_deep));
        songs.add(new Song("Sway", "Dean Martin", R.drawable.sway));
        songs.add(new Song("This Never Happened Before", "Paul McCartney", R.drawable.this_never_happened_before));
        songs.add(new Song("Thriller", "Michael Jackson", R.drawable.thriller));
        songs.add(new Song("Folsom Prison Blues", "Johnny Cash", R.drawable.folsom_prison));

        adapter = new SongAdapter(this, songs);
        listView = (ListView) findViewById(R.id.music_list);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songIntent = new Intent(MusicActivity.this, SongActivity.class);
                Song song = songs.get(position);
                // Send the values of songs ArrayList to the SongActivity
                songIntent.putExtra("songs_list", song);
                startActivity(songIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);

        return true;
    }
}

