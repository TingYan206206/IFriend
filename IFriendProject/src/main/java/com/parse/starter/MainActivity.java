/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  Button signUpBtn, loginBtn;

  @Override
  public void onClick(View view) {
    EditText username = (EditText)findViewById(R.id.usernameEditText);
    EditText password = (EditText) findViewById(R.id.passwordEditText);

    if(username.getText().toString().matches("") || password.getText().toString().matches("")){
      Toast.makeText(this, "Both username and password are required", Toast.LENGTH_SHORT).show();
    }else{
      if(view.getId() == R.id.signUpButton){
        Log.i("button clicked: ", "signup");
//        // create a new user
//        ParseUser user = new ParseUser();
//        user.setUsername(username.getText().toString());
//        user.setPassword(password.getText().toString());
//        // check if sign up successed
//        user.signUpInBackground(new SignUpCallback() {
//          @Override
//          public void done(ParseException e) {
//            if(e == null){
//              Log.i("sign up ", "Successed");
//            }else{
//              Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//          }
//        });
      }else{
        Log.i("button clicked: ", "login");
      }
    }
  }

  public boolean checkInput(View view){
    EditText username = (EditText)findViewById(R.id.usernameEditText);
    EditText password = (EditText) findViewById(R.id.passwordEditText);

    if(username.getText().toString().matches("") || password.getText().toString().matches("")){
      Toast.makeText(this, "Both username and password are required", Toast.LENGTH_SHORT).show();
    }
    return true;
  }

  public void signupClicked(View view){
    if(checkInput(view)) {




    }

    }

    public void loginClicked(View view){
      if(checkInput(view)) {
        Log.i("button clicked: ", "login");
      }

  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.loginButton).setOnClickListener(this);
    findViewById(R.id.signUpButton).setOnClickListener(this);






    /*  // create a new user
    ParseUser user = new ParseUser();
    user.setUsername("Ting");
    user.setPassword("mypass");
    user.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if(e == null){
          Log.i("sign up ok", "signed");
        }else{
          e.printStackTrace();
        }
      }
    });


  // log in user
    ParseUser.logInInBackground("Ting", "mypass", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if(user != null){
          Log.i("success ", "loged in ");
        }else {
          e.printStackTrace();
        }
      }
    });

     */


    ParseUser.logOut();
    // check if user has signed in
    if(ParseUser.getCurrentUser() != null){
      Log.i("signed in ", ParseUser.getCurrentUser().getUsername());
    }else {
      Log.i("not luck ", "not signed in");
    }

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}