package com.shane.demo.activities.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.shane.demo.R;
import com.shane.demo.activities.profile.ProfileActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.coordinatorLayout) CoordinatorLayout coordinatorLayout;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.nav_view) NavigationView navigationView;
    @Bind(R.id.toolbar) Toolbar toolbar;

    private MenuItem homeItem, recentItem, favouriteItem , profileItem, settingsItem, helpItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initializeDrawer();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initializeDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        LinearLayout headerLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_header, null);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateMenu(R.menu.menu_drawer);
        navigationView.addHeaderView(headerLayout);

//        usernameView = ButterKnife.findById(headerLayout, R.id.username_display);

        Menu navMenu = navigationView.getMenu();

        homeItem = navMenu.findItem(R.id.nav_home);
        profileItem = navMenu.findItem(R.id.nav_profile);
        recentItem = navMenu.findItem(R.id.nav_recent);
        favouriteItem = navMenu.findItem(R.id.nav_favourite);

        settingsItem = navMenu.findItem(R.id.nav_settings);
        helpItem = navMenu.findItem(R.id.nav_help);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//
//        searchView.setOnQueryTextListener(
//                new SearchView.OnQueryTextListener() {
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
//                        return false;
//                    }
//                }
//        );
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Snackbar.make(coordinatorLayout, "Settings pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_filter:
                Snackbar.make(coordinatorLayout, "Filter pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_search:

                Snackbar.make(coordinatorLayout, "Search pressed", Snackbar.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Snackbar.make(coordinatorLayout, "Home pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_recent:
                Snackbar.make(coordinatorLayout, "Recent pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_profile:
                Snackbar.make(coordinatorLayout, "Profile pressed", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                break;
            case R.id.nav_favourite:
                Snackbar.make(coordinatorLayout, "Favourite pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_settings:
                Snackbar.make(coordinatorLayout, "Settings pressed", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_help:
                Snackbar.make(coordinatorLayout, "Help pressed", Snackbar.LENGTH_LONG).show();
                break;
        }

        return true;
    }
}
