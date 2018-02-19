package com.ezerski.vladislav.omertextp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullInfoActivity extends AppCompatActivity {

    public final static String ID = "ID";
    public final static String TITLE = "title";
    public final static String BODY = "body";
    public final static String URL = "url";

    TextView userId;
    TextView textTitle;
    TextView textBody;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_info_item);

        userId = findViewById(R.id.itemUserId);
        textTitle = findViewById(R.id.itemTextTitle);
        textBody = findViewById(R.id.itemTextBody);
        imageView = findViewById(R.id.itemImageView);

        userId.setText("" + getIntent().getIntExtra(ID, 0));
        textTitle.setText(getIntent().getStringExtra(TITLE));
        textBody.setText(getIntent().getStringExtra(BODY));

        Picasso.with(this).load(getIntent().getStringExtra(URL)).into(imageView);
    }
}
