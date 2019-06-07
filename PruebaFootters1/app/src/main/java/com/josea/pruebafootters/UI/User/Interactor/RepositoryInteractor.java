package com.josea.pruebafootters.UI.User.Interactor;

import com.josea.pruebafootters.UI.Entities.Repository;

import java.util.List;

public interface RepositoryInteractor {
    void getRepositories(String repos_url,OnGetRepositories callBack);

    interface OnGetRepositories{
        void onSuccessRepositories(List<Repository> repositoryList);
        void onErroReopositories(int code);
    }
}
