package com.example.levoyage;

import android.content.Intent;
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
    public static final String USER_ID = "";
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager=findViewById(R.id.fragment_container);
        setUpAdapter(viewPager);

        Intent intent = getIntent();

        int id = intent.getIntExtra(USER_ID, 0);
        user = UserDatabase.getDatabase(this).myUserDAO().getUser(id);
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



    }

    private void setUpAdapter(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new ExploreFragment());
        viewPageAdapter.addFragment(new SavedFragment());
        viewPageAdapter.addFragment(new ProfileFragment());
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
                case R.id.nav_saved:
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
