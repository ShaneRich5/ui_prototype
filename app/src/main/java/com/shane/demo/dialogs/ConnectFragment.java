package com.shane.demo.dialogs;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.shane.demo.R;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class ConnectFragment extends DialogFragment {

    @Bind(R.id.container) LinearLayout containerLayout;

    @Bind(R.id.email) EditText emailEt;
    @Bind(R.id.password) EditText passwordEt;
    @Bind(R.id.connect) Button connectBtn;
    @Bind(R.id.toggle) Button toggleBtn;
    @Bind(R.id.guest) Button guestBtn;

    // registration specific
    @Bind(R.id.username) EditText usernameEt;
    @Bind(R.id.confirm) EditText confirmEt;

    // prompts
    @BindString(R.string.action_sign_in) String loginPrompt;
    @BindString(R.string.action_register) String registerPrompt;
    @BindString(R.string.action_not_a_member) String joinPrompt;
    @BindString(R.string.action_is_a_member) String memberPrompt;

    // bundle arg keys
    private static final String ARG_STATE = "connect";

    private int mState;

    // callback
    private OnConnectListener mListener;

    public static ConnectFragment newInstance(int state) {
        ConnectFragment fragment = new ConnectFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATE, state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mState = getArguments().getInt(ARG_STATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_connect, container, false);
        ButterKnife.bind(this, view);

        // initialize displayed views
        toggleState(mState);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            mListener = (OnConnectListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnConnectListener");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void toggleState(int state) {
        /*
         * state 0 - register
         * state 1 - login
         */
        switch (state) {
            case 0:
                connectBtn.setText(registerPrompt);
                toggleBtn.setText(memberPrompt);
                usernameEt.setVisibility(View.VISIBLE);
                confirmEt.setVisibility(View.VISIBLE);
                break;
            case 1:
                connectBtn.setText(loginPrompt);
                toggleBtn.setText(joinPrompt);
                usernameEt.setVisibility(View.GONE);
                confirmEt.setVisibility(View.GONE);
                break;
        }
    }

    @OnClick(R.id.connect)
    public void connectButtonClicked() {
        String email = extractTextFromField(emailEt);
        String username = extractTextFromField(usernameEt);
        String password = extractTextFromField(passwordEt);
        String confirm = extractTextFromField(confirmEt);

        boolean hasErrors = false;

        // add validation

        if (!hasErrors) {

            dismiss();
            switch (mState) {
                case 0:
                    mListener.attemptRegister(username, email, password);
                    break;
                case 1:
                    mListener.attemptLogin(email, password);
                    break;
            }
        }
    }

    @OnClick(R.id.toggle)
    public void toggleButtonClicked() {
        mState = 1 - mState; // toggle state
        toggleState(mState);
    }

    @OnClick(R.id.guest)
    public void guestButtonClicked() {
        dismiss();
    }

    private boolean isEmailValid(String email) {
        return !email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return !(password.length() > 4);
    }

    private boolean isPasswordValid(String password, String confirmation) {
        return !(isPasswordValid(password) && password.equals(confirmation));
    }

    // helpers
    private String extractTextFromField(EditText field) {
        return field.getText().toString().trim();
    }

    // callback
    public interface OnConnectListener {
        void attemptLogin(String email, String password);

        void attemptRegister(String username, String email, String password);

        void forgotPassword();
    }
}