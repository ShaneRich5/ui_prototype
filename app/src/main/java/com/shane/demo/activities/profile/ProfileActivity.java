package com.shane.demo.activities.profile;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.shane.demo.R;
import com.shane.demo.activities.main.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tab_layout) TabLayout tabs;
    @Bind(R.id.backdrop) ImageView ivProfileImage;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setupTabLayout();

    }

    private void setupTabLayout() {
        if (tabs == null)
            return;

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.addTab(tabs.newTab().setText(""));
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