package com.ezerski.vladislav.omertextp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ezerski.vladislav.omertextp.adapters.ImagesAdapter;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.addUrlToList;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.urls;

public class ImageActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        listView = findViewById(R.id.images_list_view);

        addUrlToList();

        listView.setAdapter(new ImagesAdapter(getApplicationContext(), urls));
    }
}