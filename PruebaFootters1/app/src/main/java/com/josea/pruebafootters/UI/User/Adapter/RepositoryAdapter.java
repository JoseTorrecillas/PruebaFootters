package com.josea.pruebafootters.UI.User.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josea.pruebafootters.R;
import com.josea.pruebafootters.UI.Entities.Repository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.CustomViewHolder> {

    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewLanguage)
    TextView textViewLanguage;
    @BindView(R.id.textViewLike)
    TextView textViewLike;
    @BindView(R.id.textViewForks)
    TextView textViewForks;
    private List<Repository> repositoryList;

    public RepositoryAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_repository, viewGroup, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.repository=repositoryList.get(i);
        customViewHolder.textViewName.setText(customViewHolder.repository.getName());
        if (customViewHolder.repository.getDescription()!=null){
            customViewHolder.textViewDescription.setText(customViewHolder.repository.getDescription());
        }
        if (customViewHolder.repository.getLanguage()!=null){
            customViewHolder.textViewLanguage.setText(customViewHolder.repository.getLanguage());
        }
        customViewHolder.textViewLike.setText(String.valueOf(customViewHolder.repository.getStargazers_count()));
        customViewHolder.textViewForks.setText(String.valueOf(customViewHolder.repository.getForks_count()));

    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewName)
        TextView textViewName;
        @BindView(R.id.textViewDescription)
        TextView textViewDescription;
        @BindView(R.id.textViewLanguage)
        TextView textViewLanguage;
        @BindView(R.id.textViewLike)
        TextView textViewLike;
        @BindView(R.id.textViewForks)
        TextView textViewForks;
        Repository repository;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
