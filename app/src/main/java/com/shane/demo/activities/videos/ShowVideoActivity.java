package com.shane.demo.activities.videos;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shane.demo.R;
import com.shane.demo.adapters.ViewPagerAdapter;
import com.shane.demo.fragments.CommentFragment;
import com.shane.demo.fragments.InfoFragment;
import com.shane.demo.fragments.ListVideoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowVideoActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tabs) TabLayout tabs;
    @Bind(R.id.pager) ViewPager pager;

    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(CommentFragment.newInstance(), "Comments");
        adapter.addFragment(InfoFragment.newInstance(), "Info");
        adapter.addFragment(ListVideoFragment.newInstance(), "Related");

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

}
