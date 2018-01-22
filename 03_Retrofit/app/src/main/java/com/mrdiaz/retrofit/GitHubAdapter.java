package com.mrdiaz.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by mrdiaz on 22/01/2018.
 */

class GitHubAdapter extends ArrayAdapter<GitHubRepo> {

    Context ctx;
    int template;
    List<GitHubRepo> listaGit;


    public GitHubAdapter(@NonNull Context context, int resource, @NonNull List<GitHubRepo> objects) {
        super(context, resource, objects);
    }
}
