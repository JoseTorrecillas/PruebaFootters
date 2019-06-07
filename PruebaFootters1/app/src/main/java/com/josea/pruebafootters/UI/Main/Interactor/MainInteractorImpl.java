package com.josea.pruebafootters.UI.Main.Interactor;

import com.josea.pruebafootters.UI.Entities.BaseResponse;
import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.User;
import com.josea.pruebafootters.UI.Module.ApiModule;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractorImpl implements MainInteractor {
    @Inject
    public MainInteractorImpl() {
    }

    @Inject
    ApiModule apiModule;

    @Override
    public void getMembersOrg(OngetMembersOrg callBack) {
        Call<List<Member>> call = apiModule.getMember();
        call.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                if (response.code()==200){
                    callBack.onSuccessMember(response.body());
                }else{
                    callBack.onErrorMember(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {
                callBack.onErrorMember(-1);
            }
        });
    }

    @Override
    public void getUser(String url, OngetUser callBack) {
        Call<User> call = apiModule.getUser(url);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code()==200){
                    callBack.onSuccesUser(response.body());
                }else{
                    callBack.onErrorUser(response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callBack.onErrorUser(-1);
            }
        });
    }
}
