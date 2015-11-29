package com.shane.demo.activities.articles;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shane.demo.R;

import butterknife.Bind;

public class NewArticleActivity extends AppCompatActivity {

    @Bind(R.id.post_container) LinearLayout baseContainer;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.author) TextView tvAuthor;
    @Bind(R.id.title) EditText etTitle;
    @Bind(R.id.body) EditText etBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);

        setupToolbar();

    }

    @SuppressWarnings("ConstantConditions")
    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
