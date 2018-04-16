package com.example.android.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * {@link Song} represents a song that the user wants to listen.
 * It contains the song title, singer and poster.
 */

public class Song implements Serializable {
    // The song title
    private String mSongTitle;
    // The singer of the song
    private String mSinger;
    // The poster image resource id for the image view
    private int mImageResourceId;


    /**
     * Create a new Song object.
     *
     * @param songTitle is the name of the song
     * @param singer is the singer of the song
     *
     * @param imageResourceId is the drawable resource id for the image associated with the song
     */
    public Song(String songTitle, String singer, int imageResourceId){
        mSongTitle = songTitle;
        mSinger = singer;
        mImageResourceId = imageResourceId;
    }

    // Get the name of the song
    public String getSongTitle(){
        return mSongTitle;
    }

    // Get the singer of the song
    public String getSinger(){
        return mSinger;
    }

    // Get the drawable resource id for the image associated with the song
    public int getImageResourceId(){
        return mImageResourceId;
    }
}
