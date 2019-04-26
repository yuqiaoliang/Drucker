package com.example.yueyingwu.drucker_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.*;

import java.net.URLEncoder;
import java.util.*;

import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PostDetailActivity extends AppCompatActivity {
    static String postError;
    static String postTitle;
    static String postAuthor;
    static String postTime;
    static String postContent;
    static ArrayList<Message> postComments = new ArrayList<Message>();
    static int postPID;
    static int postCommentNum;

    static EditText etNewComment;

    static ListView listViewPost;
    static ArrayList<String> postDetailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        //We have our list view
        listViewPost = findViewById(R.id.listViewPost);

        Intent receivedIntent = getIntent();
        postPID = receivedIntent.getIntExtra("postID", 1);
        System.out.println(Integer.toString(postPID));
        postCommentNum = receivedIntent.getIntExtra("postCommentNum", 1);
        System.out.println(Integer.toString(postCommentNum));

        viewPostDetail viewPost = new viewPostDetail();
        viewPost.execute();

        final Button button = (Button) findViewById(R.id.bNewComment);
//        final TextView tvNewCommentView = findViewById(R.id.tvNewCommentView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostDetailActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.new_comment_dialog, null);
                etNewComment = (EditText) mView.findViewById(R.id.etNewComment);
                /**
                 Button bPostComment = (Button)mView.findViewById(R.id.bPostComment);
                 /bPostComment.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                tvNewCommentView.setText(etNewComment.getText().toString());
                }
                });
                 //openDialog();
                 **/
                builder.setView(mView)
                        .setTitle("New Comment")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Post Comment", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                tvNewCommentView.setText(etNewComment.getText().toString());
                                //Here you add new comment to ArrayList
//                                postDetailList.add(etNewComment.getText().toString());
                                if (etNewComment.getText().toString().equals("")) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(PostDetailActivity.this);
                                    builder.setMessage("Cannot post empty comment").setNegativeButton("Re-enter comment", null).create().show();
                                } else {
                                    NewComment postNewComment = new NewComment();
                                    postNewComment.execute();
                                }
                            }
                        })
                ;
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public class DetailAdapter extends BaseAdapter {

        private String NAME;
        private String TITLE;
        private String TIME;
        private String CONTENT;
        private int COMMENTNUM;
        private ArrayList<Message> POSTCOMMENTS;


        public DetailAdapter(String names, String titles, String times, String content, int num, ArrayList<Message> comments) {
            this.NAME = names;
            this.TIME = times;
            this.TITLE = titles;
            this.CONTENT = content;
            this.COMMENTNUM = num;
            this.POSTCOMMENTS = comments;
        }


        @Override
        public int getCount() {
            int num = COMMENTNUM + 2;
            return num; // + number of comment;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (position == 0) {
                convertView = getLayoutInflater().inflate(R.layout.custom_detail_title, null);
                TextView tvTitle = convertView.findViewById(R.id.tvTitle);
                TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);
                TextView tvContent = convertView.findViewById(R.id.tvContent);
                tvTitle.setText(TITLE);
                tvAuthor.setText("Author: " + NAME + "              Time: " + TIME);
                tvContent.setText(CONTENT);
            }
            if (position == 1) {
                convertView = getLayoutInflater().inflate(R.layout.custom_detail_line, null);
                TextView tvTitle = convertView.findViewById(R.id.tvTitle);
//                TextView tvAuthor=convertView.findViewById(R.id.tvAuthor);
//                TextView tvContent=convertView.findViewById(R.id.tvContent);
                tvTitle.setText("Comments ");
//                tvAuthor.setText("Author: " +POSTCOMMENTS.get(position-1).getUsername() + " " + "Time: "  +POSTCOMMENTS.get(position-1).getStime());
//                tvContent.setText( POSTCOMMENTS.get(position-1).getContent() );
            }
            if (position > 1) {
                convertView = getLayoutInflater().inflate(R.layout.custom_detail_content, null);
//                TextView tvTitle = convertView.findViewById(R.id.tvTitle);
                TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);
                TextView tvContent = convertView.findViewById(R.id.tvContent);
//                tvTitle.setText(" Comments ");
                tvAuthor.setText("Author: " + POSTCOMMENTS.get(position - 2).getUsername() + "              Time: " + POSTCOMMENTS.get(position - 2).getStime());
                tvContent.setText(POSTCOMMENTS.get(position - 2).getContent());
                tvContent.getAutoLinkMask();
            }


            return convertView;
        }

        //return null;
    }

    private class viewPostDetail extends AsyncTask<Void, Void, Void> {
        private String receiveDetailInfo = "";

        @Override
        protected Void doInBackground(Void... voids) {
            String sendURL = "http://10.197.189.82:8080/forum/post?postid=" + Integer.toString(postPID);
//            String sendURL="http://10.197.189.82:8080/forum/post?postid="+Integer.toString(postPID);
            String method = "GET";
            fetchResult postDetail = new fetchResult(sendURL, method);
            receiveDetailInfo = postDetail.getResult();
//            System.out.println(receiveDetailInfo);
            try {
                JSONObject postInfo = new JSONObject(receiveDetailInfo);
                postError = postInfo.getString("errorMsg");
                if (postError.equals("success")) {
                    postTitle = postInfo.getString("title");
                    postAuthor = postInfo.getString("author");
                    postTime = postInfo.getString("time");
                    postContent = postInfo.getString("content");
                    JSONArray jsonComments = postInfo.getJSONArray("comments");
                    for (int i = 0; i < jsonComments.length(); i++) {
                        JSONObject tmpCommentObj = jsonComments.getJSONObject(i);
                        String tmpContent = tmpCommentObj.getString("content");
//                        String tmpShortContent=tmpCommentObj.getString("shortContent");
                        String tmpAuthor = tmpCommentObj.getString("username");
                        String tmpTime = tmpCommentObj.getString("stime");
                        int tmpID = tmpCommentObj.getInt("id");
                        Message commentTmp = new Message(tmpContent, tmpAuthor, tmpTime, tmpID);
                        postComments.add(commentTmp);
                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            postDetailList.add("Title: " + postTitle);
            postDetailList.add("Author: " + postAuthor);
            postDetailList.add("Time: " + postTime);
            postDetailList.add("Content: ");
            postDetailList.add(postContent);
            postDetailList.add("Comment:");
            for (int i = 0; i < postComments.size(); i++) {
                postDetailList.add(postComments.get(i).getContent());
            }
            DetailAdapter adapterPostDetail = new DetailAdapter(postAuthor, postTitle, postTime, postContent, postComments.size(), postComments);
//            ArrayAdapter<String> adapterPostDetail = new ArrayAdapter<>(com.example.yueyingwu.testapp.PostDetailActivity.this, android.R.layout.simple_list_item_1, postDetailList);
            listViewPost.setAdapter(adapterPostDetail);


        }
    }

    private class NewComment extends AsyncTask<Void, Void, Void> {
        private String receiveDetailInfo = "";

        @Override
        protected Void doInBackground(Void... voids) {
            String CommentContent = etNewComment.getText().toString();
            String CommentAuthor = UserActivity.username;
            String encodedCommentConetent = URLEncoder.encode(CommentContent);
            String encodedAuthor = URLEncoder.encode(CommentAuthor);
            String sendURL = "http://10.197.189.82:8080/forum/newcomment?content=" + encodedCommentConetent + "&commenter=" + encodedAuthor + "&postid=" + Integer.toString(postPID);
//            String sendURL="http://10.197.189.82:8080/forum/newcomment?content="+encodedCommentConetent+"&commenter="+encodedAuthor+"&postid="+Integer.toString(postPID);
            String method = "GET";
            fetchResult postDetail = new fetchResult(sendURL, method);
            receiveDetailInfo = postDetail.getResult();
//            System.out.println(receiveDetailInfo);
            try {
                JSONObject postInfo = new JSONObject(receiveDetailInfo);
                postError = postInfo.getString("errorMsg");
                if (postError.equals("success")) {
                    postTitle = postInfo.getString("title");
                    postAuthor = postInfo.getString("author");
                    postTime = postInfo.getString("time");
                    postContent = postInfo.getString("content");
                    postComments.clear();
                    JSONArray jsonComments = postInfo.getJSONArray("comments");
                    for (int i = 0; i < jsonComments.length(); i++) {
                        JSONObject tmpCommentObj = jsonComments.getJSONObject(i);
                        String tmpContent = tmpCommentObj.getString("content");
//                        String tmpShortContent=tmpCommentObj.getString("shortContent");
                        String tmpAuthor = tmpCommentObj.getString("username");
                        String tmpTime = tmpCommentObj.getString("stime");
                        int tmpID = tmpCommentObj.getInt("id");
                        Message commentTmp = new Message(tmpContent, tmpAuthor, tmpTime, tmpID);
                        postComments.add(commentTmp);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "This post no longer exist", Toast.LENGTH_SHORT).show();
                    Intent ErrorPost = new Intent(getApplicationContext(), ViewPostActivity.class);
                    PostDetailActivity.this.startActivity(ErrorPost);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            postDetailList.clear();
            postDetailList.add("Title: " + postTitle);
            postDetailList.add("Author: " + postAuthor);
            postDetailList.add("Time: " + postTime);
            postDetailList.add("Content: ");
            postDetailList.add(postContent);
            postDetailList.add("Comment:");
            for (int i = 0; i < postComments.size(); i++) {
                postDetailList.add(postComments.get(i).getContent());
            }
            DetailAdapter adapterPostDetail = new DetailAdapter(postAuthor, postTitle, postTime, postContent, postComments.size(), postComments);
//            ArrayAdapter<String> adapterPostDetail = new ArrayAdapter<>(com.example.yueyingwu.testapp.PostDetailActivity.this, android.R.layout.simple_list_item_1, postDetailList);
            listViewPost.setAdapter(adapterPostDetail);
        }
    }
}
