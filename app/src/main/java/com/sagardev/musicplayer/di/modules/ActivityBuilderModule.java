package com.sagardev.musicplayer.di.modules;

import com.sagardev.musicplayer.di.scopes.ActivityScoped;
import com.sagardev.musicplayer.ui.view.main.MainActivity;
import com.sagardev.musicplayer.ui.view.main.MainActivityViewModelModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


//Activity Builder Module is responsible for android injection for the activity within the application to avoid separate injection in each activity like we were doing in the old dagger
@Module
public abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            MainActivityViewModelModule.class,

    })
    abstract MainActivity contributeMainActivity();


}
