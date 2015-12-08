package com.shane.demo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shane.demo.R;
import com.shane.demo.models.Article;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shane on 12/7/15.
 */
public class ListArticleFragment extends Fragment {

    @Bind(R.id.articles_list) RecyclerView rvArticles;

    ArticleAdapter adapter;

    public ListArticleFragment() {

    }

    public static ListArticleFragment newInstance() {
        ListArticleFragment fragment = new ListArticleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_article, container, false);
        ButterKnife.bind(rootView);

        setupRecyclerView();

        return rootView;
    }

    private void setupRecyclerView() {
        adapter = new ArticleAdapter(Article.getTestData());
        rvArticles.setAdapter(adapter);
    }

    public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {

        private final List<Article> articles;

        public ArticleAdapter(List<Article> articles) {
            this.articles = articles;
        }

        public void addArticle(Article newArticle) {
            articles.add(newArticle);
            notifyDataSetChanged();
        }

        @Override
        public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_article, parent, false);
            return new ArticleHolder(view);
        }

        @Override
        public void onBindViewHolder(ArticleHolder holder, int position) {
            Article article = articles.get(position);

            holder.title.setText(article.getTitle());
            holder.rating.setText(String.valueOf(article.getRating()) + "/10");
            holder.timestamp.setText(article.getTimestamp());
            holder.name.setText(article.getUser().getName());
        }

        @Override
        public int getItemCount() {
            return articles.size();
        }

        public class ArticleHolder extends RecyclerView.ViewHolder {
            CircleImageView profileImage;
            TextView timestamp;
            TextView rating;
            TextView title;
            TextView name;

            public ArticleHolder(View itemView) {
                super(itemView);

                profileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                rating = (TextView) itemView.findViewById(R.id.rating);
                title = (TextView) itemView.findViewById(R.id.title);
                name = (TextView) itemView.findViewById(R.id.name);
            }
        }
    }
}
