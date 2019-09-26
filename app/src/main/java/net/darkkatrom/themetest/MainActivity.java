package net.darkkatrom.themetest;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lightTheme(View v) {
        updateTheme(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void darkTheme(View v) {
        updateTheme(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public void systemTheme(View v) {
        updateTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    public void updateTheme(int theme) {
        AppCompatDelegate.setDefaultNightMode(theme);
    }
}
