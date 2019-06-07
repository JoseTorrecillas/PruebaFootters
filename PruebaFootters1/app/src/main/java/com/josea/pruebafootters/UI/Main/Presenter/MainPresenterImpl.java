package com.josea.pruebafootters.UI.Main.Presenter;

import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Main.Interactor.MainInteractor;

import java.util.List;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter, MainInteractor.OngetMembersOrg {
    @Inject
    public MainPresenterImpl() {
    }

    @Inject
    MainInteractor mainInteractor;

    @Override
    public void getMemberOrg() {
        mainInteractor.getMembersOrg(this);
    }

    @Override
    public void onSuccessMember(List<Member> data) {

    }

    @Override
    public void onErrorMember(int code) {

    }
}
