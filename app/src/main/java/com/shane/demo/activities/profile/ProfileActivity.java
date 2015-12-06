package com.shane.demo.activities.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.shane.demo.R;
import com.shane.demo.activities.main.BaseActivity;
import com.shane.demo.adapters.ViewPagerAdapter;
import com.shane.demo.fragments.CommentFragment;
import com.shane.demo.fragments.InfoFragment;
import com.shane.demo.fragments.ListVideoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

//import android.support.v7.graphics.Palette;

public class ProfileActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.viewpager) ViewPager pager;
    @Bind(R.id.tab_layout) TabLayout tabs;
    @Bind(R.id.backdrop) ImageView ivProfileImage;
    @Bind(R.id.main_layout) CoordinatorLayout coordinatorLayout;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setupToolbar();
        setupViewPager();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabs.setupWithViewPager(pager);
        collapsingToolbarLayout.setTitleEnabled(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        // can't import Palette for some reason


        Palette.from(bitmap).generate(palette -> {

            int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary));
            int vibrantDarkColor = palette.getDarkVibrantColor(getResources().getColor(R.color.primary_dark));
            collapsingToolbarLayout.setContentScrimColor(vibrantColor);
            collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
            tabs.setBackgroundColor(vibrantColor);
        });

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                pager.setCurrentItem(pos);
                switch (pos) {
                    case 0:
                        Snackbar.make(coordinatorLayout, "Wall", Snackbar.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Snackbar.make(coordinatorLayout, "Info", Snackbar.LENGTH_LONG).show();
                        break;
                    case 2:
                        Snackbar.make(coordinatorLayout, "Content", Snackbar.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.addTab(tabs.newTab().setText(""));
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(CommentFragment.newInstance(), "Wall");
        adapter.addFragment(InfoFragment.newInstance(), "Info");
        adapter.addFragment(ListVideoFragment.newInstance(), "Content");
        pager.setAdapter(adapter);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shane Richards");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_favourite:


                break;
            case R.id.action_settings:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}