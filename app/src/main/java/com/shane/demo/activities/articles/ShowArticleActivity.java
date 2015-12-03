package com.shane.demo.activities.articles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.shane.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowArticleActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.main_content) TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_article);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("Title");
        tvContent.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus posuere magna vestibulum metus interdum, non ultricies erat aliquam. Donec mollis tortor tellus, quis fringilla nisi pulvinar sed. In hac habitasse platea dictumst. Ut efficitur ultricies magna, vitae vestibulum lectus placerat sed. Curabitur mattis vel quam ut facilisis. Nullam ultricies eget felis vel dapibus. Praesent tortor ante, accumsan id magna at, iaculis ornare erat. Nam vel semper elit.\n" +
                "\n" +
                "Donec non justo id quam bibendum semper sed in lacus. Curabitur neque quam, imperdiet id tellus laoreet, venenatis rhoncus leo. Nam neque orci, rutrum accumsan venenatis eget, lobortis sit amet dolor. Pellentesque vulputate lacus ut tellus iaculis, et consequat lorem sollicitudin. Nulla quis risus dictum, porttitor velit vestibulum, viverra mauris. Nullam volutpat neque in enim ultricies gravida. Maecenas aliquet luctus est, non pulvinar eros pretium nec. Sed molestie sodales dui vitae vulputate. Maecenas sed hendrerit lectus. Nulla placerat id leo sit amet commodo. Curabitur in ultricies turpis. Phasellus tristique, erat id pretium lacinia, nisl libero dapibus sem, at laoreet libero ante quis augue.\n" +
                "\n" +
                "Sed sem nibh, dignissim vel sapien luctus, luctus suscipit risus. Phasellus mattis interdum venenatis. Quisque viverra elit eget mauris tincidunt, eget fringilla dui sollicitudin. Integer nec eleifend mi. Morbi ac tempus quam, a placerat risus. Duis tincidunt mi in leo euismod sollicitudin. Vivamus at arcu dui. Mauris at viverra nisl. Ut ac urna quam.\n" +
                "\n" +
                "Suspendisse potenti. Etiam sit amet lacinia orci, suscipit malesuada ipsum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec dolor nunc, tempus sed quam at, blandit interdum massa. Phasellus rhoncus leo vel feugiat venenatis. Vestibulum quis elit metus. Fusce varius magna elit, a facilisis nibh pretium consequat. Vestibulum purus leo, scelerisque ut nisi et, iaculis venenatis nibh. Nam malesuada pulvinar nisl sit amet congue. Donec accumsan tortor at metus pellentesque vestibulum.\n" +
                "\n" +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi non imperdiet risus. Nulla viverra varius neque, a dictum elit sagittis ut. Donec efficitur ipsum sit amet est venenatis, in ornare ante fringilla. Morbi consectetur, arcu in fringilla venenatis, nisi lectus placerat mauris, et blandit nisi est in sapien. Nunc lobortis rhoncus purus at volutpat. Nullam pretium eget magna faucibus ultricies. Sed aliquet elit id risus luctus feugiat eu ac erat. Proin nec ex neque. Phasellus eu vulputate augue. Mauris id facilisis tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis pharetra hendrerit libero vel consequat. Sed mollis massa non pellentesque pharetra. Suspendisse et tristique sem, quis egestas risus.\n\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus posuere magna vestibulum metus interdum, non ultricies erat aliquam. Donec mollis tortor tellus, quis fringilla nisi pulvinar sed. In hac habitasse platea dictumst. Ut efficitur ultricies magna, vitae vestibulum lectus placerat sed. Curabitur mattis vel quam ut facilisis. Nullam ultricies eget felis vel dapibus. Praesent tortor ante, accumsan id magna at, iaculis ornare erat. Nam vel semper elit.\n" +
                "\n" +
                "Donec non justo id quam bibendum semper sed in lacus. Curabitur neque quam, imperdiet id tellus laoreet, venenatis rhoncus leo. Nam neque orci, rutrum accumsan venenatis eget, lobortis sit amet dolor. Pellentesque vulputate lacus ut tellus iaculis, et consequat lorem sollicitudin. Nulla quis risus dictum, porttitor velit vestibulum, viverra mauris. Nullam volutpat neque in enim ultricies gravida. Maecenas aliquet luctus est, non pulvinar eros pretium nec. Sed molestie sodales dui vitae vulputate. Maecenas sed hendrerit lectus. Nulla placerat id leo sit amet commodo. Curabitur in ultricies turpis. Phasellus tristique, erat id pretium lacinia, nisl libero dapibus sem, at laoreet libero ante quis augue.\n" +
                "\n" +
                "Sed sem nibh, dignissim vel sapien luctus, luctus suscipit risus. Phasellus mattis interdum venenatis. Quisque viverra elit eget mauris tincidunt, eget fringilla dui sollicitudin. Integer nec eleifend mi. Morbi ac tempus quam, a placerat risus. Duis tincidunt mi in leo euismod sollicitudin. Vivamus at arcu dui. Mauris at viverra nisl. Ut ac urna quam.\n" +
                "\n" +
                "Suspendisse potenti. Etiam sit amet lacinia orci, suscipit malesuada ipsum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec dolor nunc, tempus sed quam at, blandit interdum massa. Phasellus rhoncus leo vel feugiat venenatis. Vestibulum quis elit metus. Fusce varius magna elit, a facilisis nibh pretium consequat. Vestibulum purus leo, scelerisque ut nisi et, iaculis venenatis nibh. Nam malesuada pulvinar nisl sit amet congue. Donec accumsan tortor at metus pellentesque vestibulum.\n" +
                "\n" +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi non imperdiet risus. Nulla viverra varius neque, a dictum elit sagittis ut. Donec efficitur ipsum sit amet est venenatis, in ornare ante fringilla. Morbi consectetur, arcu in fringilla venenatis, nisi lectus placerat mauris, et blandit nisi est in sapien. Nunc lobortis rhoncus purus at volutpat. Nullam pretium eget magna faucibus ultricies. Sed aliquet elit id risus luctus feugiat eu ac erat. Proin nec ex neque. Phasellus eu vulputate augue. Mauris id facilisis tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis pharetra hendrerit libero vel consequat. Sed mollis massa non pellentesque pharetra. Suspendisse et tristique sem, quis egestas risus.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_show_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:

                break;
            case R.id.action_settings:

                break;
        }
        return true;
    }
}
