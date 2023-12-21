package com.example.assigment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.assigment.Adapters.FragmentAdapters;
import com.example.assigment.Fragments.BottomNavigationFragment.ChatFragment;
import com.example.assigment.Fragments.BottomNavigationFragment.ContactFragment;
import com.example.assigment.Fragments.BottomNavigationFragment.ExploreFragment;
import com.example.assigment.Fragments.BottomNavigationFragment.GroupFragment;
import com.example.assigment.Fragments.BottomNavigationFragment.NetworkFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView refine=findViewById(R.id.refineIcon);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarColor(getResources().getColor(R.color.statusBarColor));
        }

        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RefinePage.class);
                startActivity(intent);
            }
        });





        ImageView navigationIcon = findViewById(R.id.navigationIcon);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);




        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment=null;



            // Check which item was clicked

            if (item.getItemId()==R.id.explore) {
                selectedFragment = new ExploreFragment();
            }

            else  if (item.getItemId()==R.id.network) {
                selectedFragment = new NetworkFragment();
            }

            else if (item.getItemId()==R.id.chat) {
                selectedFragment = new ChatFragment();
            }

            else if (item.getItemId()==R.id.contact) {
                selectedFragment = new ContactFragment();
            }

            else if (item.getItemId()==R.id.group) {
                selectedFragment = new GroupFragment();
            }


            // Replace the content frame with the selected fragment
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selectedFragment)
                        .commit();
            }




            return true;
        });

        // Set the default fragment (e.g., HomeFragment) when the activity starts
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new ExploreFragment())
                .commit();


    }
    private void setStatusBarColor(int color) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }
}