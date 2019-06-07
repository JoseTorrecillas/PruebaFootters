package com.josea.pruebafootters.UI.User.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.josea.pruebafootters.R;
import com.josea.pruebafootters.UI.Entities.Repository;
import com.josea.pruebafootters.UI.Entities.User;
import com.josea.pruebafootters.UI.Module.AppComponent;
import com.josea.pruebafootters.UI.Module.AppModule;
import com.josea.pruebafootters.UI.Module.DaggerAppComponent;
import com.josea.pruebafootters.UI.User.Adapter.RepositoryAdapter;
import com.josea.pruebafootters.UI.User.Presenter.RepositoryPresenter;
import com.josea.pruebafootters.UI.User.Views.MemberUserView;
import com.josea.pruebafootters.UI.Utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemberActivity extends AppCompatActivity implements MemberUserView {

    @BindView(R.id.imageViewProfile)
    ImageView imageViewProfile;
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewNick)
    TextView textViewNick;
    @BindView(R.id.recyclerRepositories)
    RecyclerView recyclerRepositories;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @Inject
    RepositoryPresenter repositoryPresenter;
    @BindView(R.id.textViewError)
    TextView textViewError;
    private User user;
    private List<Repository> repositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        ButterKnife.bind(this);
        initRecycler();
        if (getIntent().getExtras() != null) {
            this.user = getIntent().getExtras().getParcelable(Constants.USERS);
            Glide.with(imageViewProfile)
                    .load(user.getAvatar_url())
                    .into(imageViewProfile);
            if (user.getName() != null) {
                textViewName.setText(user.getName());
            } else {
                textViewName.setVisibility(View.GONE);
            }
            textViewNick.setText(user.getLogin());

            repositoryPresenter.getRepositories(user.getRepos_url());
        } else {
           textViewError.setVisibility(View.VISIBLE);
           textViewError.setText(getText(R.string.no_user).toString());


        }

    }

    private void initInjection() {
        AppComponent avppmComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        avppmComponent.inject(this);
    }

    @Override
    public void setRepositories(List<Repository> repositoryList) {
        repositories = repositoryList;
        initRecycler();
        progressBar2.setVisibility(View.GONE);
    }

    @Override
    public void failRepositories(int code) {
        if (code != -1) {
            textViewError.setText(getText(R.string.error).toString()+code);
        } else {
            textViewError.setText(getText(R.string.error_failure).toString());
        }
        textViewError.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.GONE);
    }

    private void initRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RepositoryAdapter repositoryAdapter = new RepositoryAdapter(repositories);
        recyclerRepositories.setAdapter(repositoryAdapter);
        recyclerRepositories.setLayoutManager(linearLayoutManager);
    }
}
