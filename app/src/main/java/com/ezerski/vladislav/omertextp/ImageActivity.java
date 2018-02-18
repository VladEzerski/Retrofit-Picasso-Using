package com.ezerski.vladislav.omertextp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.ezerski.vladislav.omertextp.adapters.ImagesAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {
    public static final String URL1 = "https://i.imgur.com/tXtwrPd.jpg";
    public static final String URL2 = "https://i.imgur.com/sduLRvf.jpg";
    public static final String URL3 = "https://i.imgur.com/IVyU5Im.jpg";
    public static final String URL4 = "https://i.imgur.com/QguApMA.jpg";
    public static final String URL5 = "https://i.imgur.com/Xulubox.jpg";
    public static final String URL6 = "https://i.imgur.com/yxovJ4S.jpg";
    public static final String URL7 = "https://i.imgur.com/fNXT1wc.jpg";
    public static final String URL8 = "https://i.imgur.com/gjEZAJ7.jpg";
    public static final String URL9 = "https://i.imgur.com/JHHx0AD.jpg";
    public static final String URL10 = "https://i.imgur.com/PnSeZX3.jpg";


    List<String> urls = new ArrayList<>();


    ListView listView;

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        listView = findViewById(R.id.images_list_view);

        urls.add(URL1);
        urls.add(URL2);
        urls.add(URL3);
        urls.add(URL4);
        urls.add(URL5);
        urls.add(URL6);
        urls.add(URL7);
        urls.add(URL8);
        urls.add(URL9);
        urls.add(URL10);

        //ImagesAdapter adapter = new ImagesAdapter(getApplicationContext(), urls);
        listView.setAdapter(new ImagesAdapter(getApplicationContext(), urls));
    }
}
