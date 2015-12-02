package com.shane.demo.activities.videos;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shane.demo.R;
import com.shane.demo.fragments.CommentFragment;
import com.shane.demo.fragments.InfoFragment;
import com.shane.demo.fragments.ListVideoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowVideoActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tabs) TabLayout tabs;
    @Bind(R.id.pager) ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 1:
                        return CommentFragment.newInstance();
                    case 2:
                        return InfoFragment.newInstance();
                    case 3:
                        return ListVideoFragment.newInstance();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 1:
                        return "Comments";
                    case 2:
                        return "Information";
                    case 3:
                        return "Related";
                }

                return super.getPageTitle(position);
            }
        };

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

}
