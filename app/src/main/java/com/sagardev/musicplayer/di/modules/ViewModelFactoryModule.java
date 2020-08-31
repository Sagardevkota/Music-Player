package com.sagardev.musicplayer.di.modules;

import androidx.lifecycle.ViewModelProvider;


import com.sagardev.musicplayer.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

}
