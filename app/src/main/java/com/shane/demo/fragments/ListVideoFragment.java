package com.shane.demo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shane.demo.R;
import com.shane.demo.models.Video;

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
        ButterKnife.bind(this, rootView);

        setupRecyclerView();

        return rootView;
    }

    private void setupRecyclerView() {
        adapter = new VideoAdapter(Video.getTestData());
        rvVideos.setAdapter(adapter);
    }


    public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

        private final List<Video> videos;

        public VideoAdapter(List<Video> videos) {
            this.videos = videos;
        }

        public void addVideo(Video newVideo) {
            videos.add(newVideo);
            notifyDataSetChanged();
        }

        @Override
        public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);
            return new VideoHolder(view);
        }

        @Override
        public void onBindViewHolder(VideoHolder holder, int position) {
            Video video = videos.get(position);

            int duration = video.getDuration();
            int minutes = duration / 60;
            int seconds = duration % 60;

            holder.content.setText(video.getTitle());
            holder.duration.setText(minutes + ":" + seconds);
            holder.timestamp.setText(video.getTimestamp());
            holder.name.setText(video.getUser().getName());
        }

        @Override
        public int getItemCount() {
            return videos.size();
        }

        public class VideoHolder extends RecyclerView.ViewHolder {
            CircleImageView profileImage;
            TextView timestamp;
            TextView duration;
            TextView content;
            TextView name;

            public VideoHolder(View itemView) {
                super(itemView);

                profileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                duration = (TextView) itemView.findViewById(R.id.duration);
                content = (TextView) itemView.findViewById(R.id.content);
                name = (TextView) itemView.findViewById(R.id.name);
            }
        }
    }
}
