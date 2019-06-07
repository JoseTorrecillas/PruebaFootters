package com.josea.pruebafootters.UI.Main.Presenter;

import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.User;
import com.josea.pruebafootters.UI.Main.Interactor.MainInteractor;
import com.josea.pruebafootters.UI.Main.Views.MainView;

import java.util.List;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter, MainInteractor.OngetMembersOrg, MainInteractor.OngetUser {
    @Inject
    public MainPresenterImpl() {
    }

    @Inject
    MainInteractor mainInteractor;

    @Inject
    MainView mainView;

    @Override
    public void getMemberOrg() {
        mainInteractor.getMembersOrg(this);
    }

    @Override
    public void getUser(String url) {
        mainInteractor.getUser(url,this);
    }

    @Override
    public void onSuccessMember(List<Member> data) {
        mainView.setMembers(data);
    }

    @Override
    public void onErrorMember(int code) {
        mainView.failMember(code);
    }

    @Override
    public void onSuccesUser(User user) {
        mainView.addUser(user);
    }

    @Override
    public void onErrorUser(int code) {
        mainView.failUser(code);
    }
}
