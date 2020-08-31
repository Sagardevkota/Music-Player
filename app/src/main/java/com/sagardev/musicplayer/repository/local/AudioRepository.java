package com.sagardev.musicplayer.repository.local;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sagardev.musicplayer.models.AudioModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AudioRepository {

    @Inject
    public AudioRepository() {
    }

    public MutableLiveData<List<AudioModel>> getAllAudioFromDevice(final Context context) {

        final MutableLiveData<List<AudioModel>> tempAudioList = new MutableLiveData<>();

        List<AudioModel> list=new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
        Cursor c = context.getContentResolver()
                .query(uri, projection, null, null, null);

        if (c != null) {
            while (c.moveToNext()) {

                AudioModel audioModel = new AudioModel();
                String path = c.getString(0);
                String album = c.getString(1);
                String artist = c.getString(2);

                String name = path.substring(path.lastIndexOf("/") + 1);

                audioModel.setName(name);
                audioModel.setAlbum(album);
                audioModel.setArtist(artist);
                audioModel.setPath(path);

                Log.e("Name :" + name, " Album :" + album);
                Log.e("Path :" + path, " Artist :" + artist);


                list.add(audioModel);
            }
            c.close();
        }

        tempAudioList.postValue(list);

        return tempAudioList;
    }
}
