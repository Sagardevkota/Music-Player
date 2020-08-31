package com.sagardev.musicplayer.ui.view.main;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sagardev.musicplayer.BaseActivity;
import com.sagardev.musicplayer.databinding.ActivityMainBinding;
import com.sagardev.musicplayer.models.AudioModel;
import com.sagardev.musicplayer.ui.adapter.MusicAdapter;
import com.sagardev.musicplayer.viewmodels.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;




public class MainActivity extends BaseActivity {

    private final String TAG="MainActivity";
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding binding;
    private MusicAdapter musicAdapter;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        mainActivityViewModel= ViewModelProviders.of(this,viewModelProviderFactory)
                .get(MainActivityViewModel.class);
        initRecyclerView();

    }

    private void initRecyclerView() {
        List<AudioModel> audioModelList=new ArrayList<>();
        mainActivityViewModel.getAudioFiles().observe(this, new Observer<List<AudioModel>>() {
            @Override
            public void onChanged(List<AudioModel> audioModels) {
                audioModelList.addAll(audioModels);
            }
        });
        musicAdapter=new MusicAdapter(audioModelList,MainActivity.this);
        musicAdapter.notifyDataSetChanged();
        binding.rvMusic.setAdapter(musicAdapter);
        binding.rvMusic.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }
}