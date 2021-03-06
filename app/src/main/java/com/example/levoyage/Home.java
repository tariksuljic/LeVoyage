package com.example.levoyage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    public User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager=findViewById(R.id.fragment_container);
        SharedPreferences sh = getSharedPreferences("UserIDShared", MODE_PRIVATE);
        int id = sh.getInt("userID", 0);
        user = UserDatabase.getDatabase(this).myUserDAO().getUser(id);
        Log.d("Error home", " "+user);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position){
                bottomNavigationView.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUpAdapter(viewPager);



    }

    private void setUpAdapter(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new ExploreFragment(user));
        viewPageAdapter.addFragment(new BookingFragment(user));
        viewPageAdapter.addFragment(new ProfileFragment(user));
        Log.d("Error home", " "+user);
        viewPager.setAdapter(viewPageAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("DEBUG","Item clicked"+item.getItemId());
            switch(item.getItemId()){
                case R.id.nav_explore:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_booked:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_profile:
                    viewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        }
    };


}
