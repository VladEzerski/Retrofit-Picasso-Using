package com.ezerski.vladislav.omertextp.adapters;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ezerski.vladislav.omertextp.R;
import com.ezerski.vladislav.omertextp.models.UserModel;

import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL1;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL10;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL2;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL3;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL4;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL5;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL6;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL7;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL8;
import static com.ezerski.vladislav.omertextp.storage.URLStorage.URL9;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(UserModel user);
    }

    private final OnItemClickListener listener;
    private List<UserModel> users;
    List<String> urls = new ArrayList<>();

    public Adapter(List<UserModel> users, List<String> urls,
                   OnItemClickListener listener) {
        this.users = users;
        this.urls = urls;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.union_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        addUrlToList();
        UserModel user = users.get(position);
        holder.bind(users.get(position), listener);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.serverText.setText(Html.fromHtml(user.getBody(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.serverText.setText(Html.fromHtml(user.getBody()));
        }
        holder.userId.setText("Id: " + user.getId().toString());
        holder.imageUrl.setText(urls.get(position));
    }

    @Override
    public int getItemCount() {
        if (users == null)
            return 0;
        return users.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        TextView serverText;
        TextView userId;
        TextView imageUrl;

         ViewHolder(View itemView) {
            super(itemView);
            serverText = itemView.findViewById(R.id.unionListTextBody);
            userId = itemView.findViewById(R.id.unionListUserId);
            imageUrl = itemView.findViewById(R.id.unionListImageURL);
        }

        public void bind(final UserModel user, final OnItemClickListener listener){
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     listener.onItemClick(user);
                 }
             });
        }
    }

    private void addUrlToList(){
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
    }
}
