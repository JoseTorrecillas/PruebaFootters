package com.josea.pruebafootters.UI.User.Interactor;

import com.josea.pruebafootters.UI.Entities.Repository;
import com.josea.pruebafootters.UI.Module.ApiModule;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryInteractorImpl implements RepositoryInteractor {

    @Inject
    ApiModule apiModule;

    @Inject
    public RepositoryInteractorImpl() {
    }


    @Override
    public void getRepositories(String repos_url, OnGetRepositories callBack) {
        Call<List<Repository>> call = apiModule.getRepositories(repos_url);
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.code()==200){
                    callBack.onSuccessRepositories(response.body());
                }else{
                    callBack.onErroReopositories(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                callBack.onErroReopositories(-1);
            }
        });
    }
}
