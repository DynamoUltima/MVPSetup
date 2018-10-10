package com.example.hp.mvpsetup.login.root;


import com.example.hp.mvpsetup.login.login.LoginActivity;
import com.example.hp.mvpsetup.login.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
