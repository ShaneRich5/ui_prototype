package com.shane.demo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shane.demo.R;
import com.shane.demo.models.Comment;
import com.shane.demo.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentFragment extends Fragment {

    @Bind(R.id.comments_list) RecyclerView rvComments;
    @Bind(R.id.comment_text_area) EditText etComment;
    @Bind(R.id.comment_options) LinearLayout containerOptions;
    @Bind(R.id.cancel) Button bCancel;
    @Bind(R.id.submit) Button bSubmit;

    CommentAdapter adapter;

    public static CommentFragment newInstance() {
        CommentFragment fragment = new CommentFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public CommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        ButterKnife.bind(view);

        setupRecyclerView();
        setupOptionsContainer();

        return view;
    }

    private void setupOptionsContainer() {
        etComment.setOnClickListener(v -> containerOptions.setVisibility(View.VISIBLE));
        bCancel.setOnClickListener(v -> containerOptions.setVisibility(View.GONE));
        bSubmit.setOnClickListener(v -> {
            String content = etComment.getText().toString();
            adapter.addComment(new Comment(content, "now", new User("Dr. Taylor")));
        });
    }

    private void setupRecyclerView() {
        adapter = new CommentAdapter(Comment.getTestData());
        rvComments.setAdapter(adapter);
    }

    public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

        private final List<Comment> comments;

        public CommentAdapter(List<Comment> comments) {
            this.comments = comments;
        }

        public void addComment(Comment newComment) {
            comments.add(newComment);
            notifyDataSetChanged();
        }

        @Override
        public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comment, parent, false);
            return new CommentHolder(view);
        }

        @Override
        public void onBindViewHolder(CommentHolder holder, int position) {
            Comment comment = comments.get(position);

            holder.content.setText(comment.getContent());
            holder.timestamp.setText(comment.getTimestamp());
            holder.name.setText(comment.getUser().getName());
        }

        @Override
        public int getItemCount() {
            return comments.size();
        }

        public class CommentHolder extends RecyclerView.ViewHolder {
            CircleImageView profileImage;
            TextView timestamp;
            TextView content;
            TextView name;

            public CommentHolder(View itemView) {
                super(itemView);

                profileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                content = (TextView) itemView.findViewById(R.id.content);
                name = (TextView) itemView.findViewById(R.id.name);
            }
        }
    }
}
