package com.sagardev.musicplayer.di.components;

import android.app.Application;

import com.sagardev.musicplayer.BaseApplication;
import com.sagardev.musicplayer.di.modules.ActivityBuilderModule;
import com.sagardev.musicplayer.viewmodels.ViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//Create an AppComponent and bind an object at the time of the creation of AppComponent
//AndroidSupportInjectionModule is a module used for dagger android in our application to support v4 fragment injection in our application
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        ViewModelProviderFactory.class,
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance //BindInstance is an annotation used to bind a particular instance or object at the time of component creation that we are binding application object at the time of AppComponent creation
        Builder application(Application application);

        AppComponent build();
    }
}
