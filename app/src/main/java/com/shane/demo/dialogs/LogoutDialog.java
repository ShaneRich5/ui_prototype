package com.shane.demo.dialogs;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.shane.demo.R;

/**
 * @author javon
 */
public class LogoutDialog extends DialogFragment {

    private OnLogoutListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            mListener = (OnLogoutListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLoginListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_fragment_logout,null);

        builder.setView(view)
                .setTitle(R.string.action_logout)
                .setMessage("Are you sure?")
                .setPositiveButton(R.string.action_logout, (dialog, id) -> {
                    //log out user
                    mListener.attemptLogout();
                })
                .setNegativeButton(R.string.cancel, (dialog, id) -> {
                    // User cancelled the dialog
                });

        return builder.create();
    }

    public interface OnLogoutListener {
        void attemptLogout();
    }
}
