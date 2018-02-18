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

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<UserModel> users;

    public Adapter(List<UserModel> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel user = users.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.serverText.setText(Html.fromHtml(user.getBody(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.serverText.setText(Html.fromHtml(user.getBody()));
        }
        holder.userId.setText("Id: " + user.getId().toString());
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

         ViewHolder(View itemView) {
            super(itemView);
            serverText = itemView.findViewById(R.id.serverText);
            userId = itemView.findViewById(R.id.serverUserId);
        }
    }
}
