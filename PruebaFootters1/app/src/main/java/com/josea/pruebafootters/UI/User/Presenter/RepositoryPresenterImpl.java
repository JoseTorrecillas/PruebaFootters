package com.josea.pruebafootters.UI.User.Presenter;

import com.josea.pruebafootters.UI.Entities.Repository;
import com.josea.pruebafootters.UI.User.Interactor.RepositoryInteractor;
import com.josea.pruebafootters.UI.User.Views.MemberUserView;

import java.util.List;

import javax.inject.Inject;

public class RepositoryPresenterImpl implements RepositoryPresenter, RepositoryInteractor.OnGetRepositories {

    @Inject
    RepositoryInteractor repositoryInteractor;
    @Inject
    MemberUserView memberUserView;

    @Inject
    public RepositoryPresenterImpl() {
    }

    @Override
    public void getRepositories(String repos_url) {
        repositoryInteractor.getRepositories(repos_url,this);
    }

    @Override
    public void onSuccessRepositories(List<Repository> repositoryList) {
        memberUserView.setRepositories(repositoryList);
    }

    @Override
    public void onErroReopositories(int code) {
        memberUserView.failRepositories(code);
    }
}
