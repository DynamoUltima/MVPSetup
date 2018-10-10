package com.example.hp.mvpsetup.login.login;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.mvpsetup.R;
import com.example.hp.mvpsetup.login.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstName,lastName;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error User not available", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "first or  last name cannot be empty", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void setFirstName(String fname) {
        firstName.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        lastName.setText(lname);
    }
}
