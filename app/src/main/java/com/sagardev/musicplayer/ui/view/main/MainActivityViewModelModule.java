package com.sagardev.musicplayer.ui.view.main;

import androidx.lifecycle.ViewModel;

import com.sagardev.musicplayer.di.scopes.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainActivityViewModelModule {
    @Binds
    @IntoMap //for mapping to particular key as multi binding
    @ViewModelKey(MainActivityViewModel.class) //it is mapping to that key
    public abstract ViewModel bindMainActivityModel(MainActivityViewModel mainActivityViewModel);
}
