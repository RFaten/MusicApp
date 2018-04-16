package com.example.android.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Faten on 11/04/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> implements Filterable {

    public SongAdapter(Activity context, ArrayList<Song> songs){
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_title);
        songTextView.setText(currentSong.getSongTitle());

        TextView singerTextView = (TextView) listItemView.findViewById(R.id.singer);
        singerTextView.setText(currentSong.getSinger());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(currentSong.getImageResourceId());

        return listItemView;
    }

}
