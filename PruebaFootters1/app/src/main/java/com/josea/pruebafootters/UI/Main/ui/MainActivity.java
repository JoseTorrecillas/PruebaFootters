package com.josea.pruebafootters.UI.Main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.josea.pruebafootters.R;
import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.User;
import com.josea.pruebafootters.UI.Main.Adapter.MemberAdapter;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenter;
import com.josea.pruebafootters.UI.Main.Views.MainView;
import com.josea.pruebafootters.UI.Module.AppComponent;
import com.josea.pruebafootters.UI.Module.AppModule;
import com.josea.pruebafootters.UI.Module.DaggerAppComponent;
import com.josea.pruebafootters.UI.User.ui.MemberActivity;
import com.josea.pruebafootters.UI.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, MemberAdapter.OnClickUser {
    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.recyclerMembers)
    RecyclerView recyclerMembers;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textViewError)
    TextView textViewError;
    private List<Member> memberList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initInjection();
        mainPresenter.getMemberOrg();
    }

    private void initInjection() {
        AppComponent avppmComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        avppmComponent.inject(this);
    }

    private void getUsers() {

        for (Member m : memberList) {
            mainPresenter.getUser(m.getUrl());
        }


    }

    @Override
    public void setMembers(List<Member> data) {
        this.memberList = data;
        getUsers();
    }

    @Override
    public void failMember(int code) {
        if (code != -1) {
            textViewError.setText(getText(R.string.error).toString()+code);
        } else {
            textViewError.setText(getText(R.string.error_failure).toString());
        }
        textViewError.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
        if (this.userList.size() == this.memberList.size()) {
            initRecylcer();
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void failUser(int code) {
        if (code != -1) {
            textViewError.setText(getText(R.string.error).toString()+code);
        } else {
            textViewError.setText(getText(R.string.error_failure).toString());
        }
        textViewError.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    private void initRecylcer() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MemberAdapter memberAdapter = new MemberAdapter(this.userList, this);
        recyclerMembers.setLayoutManager(linearLayoutManager);
        recyclerMembers.setAdapter(memberAdapter);
    }


    @Override
    public void onClickUserListener(User user) {
        Intent intent = new Intent(MainActivity.this, MemberActivity.class);
        intent.putExtra(Constants.USERS, user);
        startActivity(intent);
    }
}
