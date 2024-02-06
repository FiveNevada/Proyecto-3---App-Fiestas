package com.example.app_dm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    PlaylistsFragment playlistsFragment = new PlaylistsFragment();
    QueueFragment queueFragment = new QueueFragment();
    AccountFragment accountFragment = new AccountFragment();
    FloatingActionButton joinbtn;
    FirebaseUser user;

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        joinbtn = findViewById(R.id.Join_btn);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
                finish();

            }
        });

        bottomNavigationView = findViewById(R.id.bottom_Navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_layout,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_layout,homeFragment).commit();
                    item.setChecked(!item.isChecked());
                }else {
                    if (item.getItemId() == R.id.myplaylists) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_layout,playlistsFragment).commit();
                        item.setChecked(!item.isChecked());
                    }else {
                        if (item.getItemId() == R.id.Queue) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.Frame_layout,queueFragment).commit();
                            item.setChecked(!item.isChecked());
                        }else {
                            if (item.getItemId() == R.id.Profile) {
                                Intent intent = new Intent(getApplicationContext(), Account.class);
                                startActivity(intent);
                                finish();
                                item.setChecked(!item.isChecked());
                            }
                        }
                    }
                }
                return false;


            }
        });
    }
}
