package com.ezerski.vladislav.omertextp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.ezerski.vladislav.omertextp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagesAdapter extends ArrayAdapter {

    private List<String> urls = new ArrayList<>();

    private Context context;
    private LayoutInflater inflater;

    public ImagesAdapter(Context context, List<String> urls) {
        super(context, R.layout.image_item, urls);
        this.context = context;
        this.urls = urls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = inflater.inflate(R.layout.image_item, parent, false);
        }

        Picasso.with(context).load(urls.get(position)).into((ImageView) view);

        return view;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
