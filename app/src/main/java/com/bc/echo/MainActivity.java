package com.bc.echo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_new:
                    loadFragment(new NewFragment());
                    return true;
                case R.id.action_stats:
                    loadFragment(new StatsFragment());
                    return true;
                case R.id.action_past:
                    loadFragment(new PastFragment());
                    return true;


                default: return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.action_new);

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.linearLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}