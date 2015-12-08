package com.shane.demo.fragments;

import android.os.Bundle;
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

public class ListVideoFragment extends Fragment {

    @Bind(R.id.videos_list) RecyclerView rvVideos;

    VideoAdapter adapter;

    public ListVideoFragment() {
        // Required empty public constructor
    }

    public static ListVideoFragment newInstance() {
        ListVideoFragment fragment = new ListVideoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_video, container, false);
        ButterKnife.bind(rootView);
        return rootView;
    }


    public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

        private final List<Article> articles;

        public VideoHolder(List<Article> articles) {
            this.articles = articles;
        }

        public void addArticle(Article newArticle) {
            articles.add(newArticle);
            notifyDataSetChanged();
        }

        @Override
        public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comment, parent, false);
            return new VideoHolder(view);
        }

        @Override
        public void onBindViewHolder(VideoHolder holder, int position) {
            Article article = articles.get(position);

            holder.content.setText(article.getTitle());
            holder.timestamp.setText(article.getTimestamp());
            holder.name.setText(article.getUser().getName());
        }

        @Override
        public int getItemCount() {
            return articles.size();
        }

        public class VideoHolder extends RecyclerView.ViewHolder {
            CircleImageView profileImage;
            TextView timestamp;
            TextView content;
            TextView name;

            public VideoHolder(View itemView) {
                super(itemView);

                profileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                content = (TextView) itemView.findViewById(R.id.content);
                name = (TextView) itemView.findViewById(R.id.name);
            }
        }
    }
}
