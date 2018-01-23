package com.example.lmlopez.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lmlopez on 22/01/2018.
 */

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {

    Context mContext;
    List<GitHubRepo> data;

    public GitHubRepoAdapter(@NonNull Context context, @NonNull List<GitHubRepo> objects) {
        super(context, R.layout.item_layout, objects);
        mContext = context;
        data = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);

        TextView texto = convertView.findViewById(R.id.textView);
        ImageView imagen = convertView.findViewById(R.id.imageView);

        texto.setText(data.get(position).getName());
        Picasso
                .with(mContext)
                .load(data.get(position).getOwner().getAvatar_url())
                .into(imagen);


        return convertView;
    }
}
