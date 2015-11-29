package com.shane.demo;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private void closeCurrentFragment() {
        getSupportFragmentManager()
                .popBackStackImmediate();
    }
}