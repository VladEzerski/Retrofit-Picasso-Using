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

import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL1;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL2;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL3;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL4;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL5;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL6;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL7;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL8;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL9;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL10;

public class ImageActivity extends AppCompatActivity {


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
