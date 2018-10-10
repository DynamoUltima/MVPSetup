package com.example.hp.mvpsetup.login.root;

import android.app.Application;

import com.example.hp.mvpsetup.login.login.LoginModule;

import dagger.internal.DaggerCollections;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
