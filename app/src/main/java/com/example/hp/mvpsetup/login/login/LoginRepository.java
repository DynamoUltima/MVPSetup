package com.example.hp.mvpsetup.login.login;

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}
