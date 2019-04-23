package com.example.yueyingwu.testapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.*;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;
import java.util.concurrent.Callable;

import android.widget.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewCommentDialog extends AppCompatDialogFragment {
    private EditText etNewComment;
    private CommentDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_comment_dialog, null);
        etNewComment = view.findViewById(R.id.etNewComment);
        builder.setView(view)
                .setTitle("New Comment")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Post Comment", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    String newComment = etNewComment.getText().toString();
                    listener.applyTexts(newComment);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (CommentDialogListener) context;

        try {
            listener = (CommentDialogListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(context.toString() +
                    "must implement CommentDialogListener");
        }

    }

    public interface CommentDialogListener{
        void applyTexts(String newComment);
    }
}
