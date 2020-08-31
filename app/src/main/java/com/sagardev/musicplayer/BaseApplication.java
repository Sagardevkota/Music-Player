package com.sagardev.musicplayer;



import com.sagardev.musicplayer.di.components.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

//Base Application will be alive throughout the life cycle of an application.
// Base Application extends with DaggerApplication which is coming from dagger android
// and overrides the method which provides the AppComponent
//Base Application act as a client whereas AppComponent act as a server.
       // As you know that modules are those where the dependency lives
//create builder module
public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
