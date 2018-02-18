package com.ezerski.vladislav.omertextp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ezerski.vladislav.omertextp.adapters.Adapter;
import com.ezerski.vladislav.omertextp.adapters.ImagesAdapter;
import com.ezerski.vladislav.omertextp.impl.Api;
import com.ezerski.vladislav.omertextp.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static Api api;

    List<UserModel> users;
    List<String> urls = new ArrayList<>();

    RecyclerView recyclerView;
    Button btnLoadText;
    Button btnLoadImage;

    ImageView imageView;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = Controller.getApi();

        users = new ArrayList<>();

        recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        imageView = findViewById(R.id.imageView);

        listView = findViewById(R.id.images_list_view);

        btnLoadText = findViewById(R.id.btnLoadText);
        btnLoadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Adapter adapter = new Adapter(users);
                recyclerView.setAdapter(adapter);

                api.getData(2).enqueue(new Callback<List<UserModel>>() {
                    @Override
                    public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                        users.addAll(response.body());
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Loading error", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

        btnLoadImage = findViewById(R.id.btnLoadImages);
        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                startActivity(intent);




            }
        });
    }
}