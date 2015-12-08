package com.shane.demo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shane.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoFragment extends Fragment {

    @Bind(R.id.published) TextView tvPublished;
    @Bind(R.id.description) TextView tvDescription;


    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(rootView);

        setupLayout();

        return rootView;
    }

    private void setupLayout() {
        tvDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dictum tristique neque sit amet commodo. Proin mattis rutrum mi sed cursus. Aenean nec pretium risus. Aenean ornare lacinia est cursus placerat. Aenean laoreet, est sed condimentum venenatis, purus libero consequat elit, tincidunt tempor velit tortor a ipsum. Nam condimentum pulvinar odio et viverra. Aenean congue, sapien in convallis condimentum, velit ipsum consectetur quam, a egestas erat neque ut arcu. Nullam non aliquam lectus. In vel dapibus ex. Cras eget tortor sed erat dapibus luctus. Cras vel consectetur nisi, ac ultrices elit. Sed sodales justo id magna facilisis blandit. Aenean vitae nisl laoreet, iaculis tortor eu, posuere sapien.\n" +
                "\n" +
                "Etiam placerat lectus ut nunc rutrum, at ornare turpis tincidunt. Duis egestas condimentum pellentesque. Aenean lorem arcu, fringilla non est vitae, convallis luctus tortor. Phasellus vulputate ligula id lacinia lacinia. Vestibulum non dolor feugiat, mollis odio vitae, feugiat sem. In volutpat venenatis aliquet. Nulla accumsan augue eget nisl vestibulum, cursus gravida tortor iaculis.");
    }
}
