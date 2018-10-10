package com.example.hp.mvpsetup.login.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    public Context prvideContext(){
        return application;
    }
}
