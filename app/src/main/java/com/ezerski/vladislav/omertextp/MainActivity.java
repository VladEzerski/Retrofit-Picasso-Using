package com.ezerski.vladislav.omertextp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ezerski.vladislav.omertextp.adapters.Adapter;
import com.ezerski.vladislav.omertextp.controllers.Controller;
import com.ezerski.vladislav.omertextp.impl.Api;
import com.ezerski.vladislav.omertextp.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ezerski.vladislav.omertextp.storage.URLStorage.addUrlToList;

public class MainActivity extends AppCompatActivity {

    private static Api api;

    List<UserModel> users = new ArrayList<>();
    List<String> urls = new ArrayList<>();

    RecyclerView recyclerView;
    Button btnLoadText;
    Button btnLoadImage;
    Button btnShowUnionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = Controller.getApi();

        recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnLoadText = findViewById(R.id.btnLoadText);
        btnLoadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadTextData();
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

        btnShowUnionList = findViewById(R.id.btnShowUnionList);
        btnShowUnionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadList();
            }
        });
    }

    private void loadTextData(){
        api.getData(2).enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                Toast.makeText(MainActivity.this, "Data load successfully!",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Loading error!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void loadList(){
        addUrlToList();

        Adapter adapter = new Adapter(users, urls, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserModel user, int position) {
                Intent intent = new Intent(MainActivity.this, FullInfoActivity.class);
                intent.putExtra(FullInfoActivity.ID, user.getId());
                intent.putExtra(FullInfoActivity.TITLE, user.getTitle());
                intent.putExtra(FullInfoActivity.BODY, user.getBody());
                intent.putExtra(FullInfoActivity.URL, urls.get(position));
                startActivity(intent);
            }
        });
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
}