package com.sagardev.musicplayer.ui.view.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sagardev.musicplayer.models.AudioModel;
import com.sagardev.musicplayer.repository.local.AudioRepository;

import java.util.List;


import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {
    private final String TAG="MainActivityViewModel";


    private  AudioRepository audioRepository;

    @Inject
    public MainActivityViewModel(@NonNull Application application, AudioRepository audioRepository) {
        super(application);
        this.audioRepository = audioRepository;
    }


    public LiveData<List<AudioModel>> getAudioFiles()
    {
        return audioRepository.getAllAudioFromDevice(getApplication().getApplicationContext());

    }

}
