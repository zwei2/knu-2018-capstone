package com.example.capstone.design;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trade_contents extends AppCompatActivity { //trade내용 올라온 아이템의 내용에서 match버튼을 클릭할시 나오는 dialog match 할 것인지 아닌지 나뉨

    List<CommentItem> lstComments;
    String UID;
    String DATE;
    String CONTENT;
    String TITLE;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_contents);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        UID=intent.getStringExtra("UID");
        DATE=intent.getStringExtra("DATE");
        CONTENT=intent.getStringExtra("CONTENT");
        TITLE=intent.getStringExtra("TITLE");
        URL=intent.getStringExtra("URL");

        ImageView item_Profile_Image = (ImageView)findViewById(R.id.Profile_image);
        TextView item_profile_Name = (TextView)findViewById(R.id.Name);
        TextView item_Title = (TextView)findViewById(R.id.Title);
        TextView item_Content = (TextView)findViewById(R.id.Content);
        TextView item_Date = (TextView)findViewById(R.id.Date);
        ImageView item_URL = (ImageView) findViewById(R.id.item_Image);

        item_Title.setText(TITLE);
        item_Content.setText(CONTENT);
        item_Date.setText(DATE);
        Picasso.with(Trade_contents.this).load(URL).into(item_URL);
        
//        List<String> comments = Arrays.asList("Super!!!", "Loook Goood!", "Fantastic", "I love it");
//        List<String> names = Arrays.asList("John Ivanovich", "Klara Pumpernikiel", "Camile Nowakowski", "Harry Potter");
//
//        lstComments = new ArrayList<>();
//        for(int i = 0, j = 0; i < comments.size() && j < names.size(); i++, j++) {
//            lstComments.add(new CommentItem(R.drawable.picasso, comments.get(i), names.get(j), "2018.11.23"));
//        }
//
//        ListView listView = (ListView)findViewById(R.id.comment_trade);
//        CommentAdapter commentAdapter = new CommentAdapter(this, R.layout.comment_item, lstComments);
//        listView.setAdapter(commentAdapter);
//
//        Button btn = (Button)findViewById(R.id.match);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showMsg();
//            }
//        });
//
//        ImageView ivAdd = (ImageView) findViewById(R.id.sendCom);
//        ivAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void showMsg(){

        //다이얼로그 객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //속성 지정
        builder.setTitle("Real-time Trading System");
        builder.setMessage("Match 하시겠습니까?");
        //아이콘
        builder.setIcon(android.R.drawable.ic_dialog_alert);


        //예 버튼 눌렀을 때
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //텍스트 뷰 객체를 넣어줌..
                //Snackbar.make(textView ,"예버튼이 눌렸습니다",Snackbar.LENGTH_SHORT).show();
            }
        });


        //예 버튼 눌렀을 때
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //텍스트 뷰 객체를 넣어줌..
                //Snackbar.make(textView ,"아니오 버튼이 눌렸습니다",Snackbar.LENGTH_SHORT).show();
            }
        });

        //만들어주기
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
