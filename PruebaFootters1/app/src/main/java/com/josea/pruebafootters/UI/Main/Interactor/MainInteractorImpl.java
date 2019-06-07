package com.josea.pruebafootters.UI.Main.Interactor;

import com.josea.pruebafootters.UI.Entities.BaseResponse;
import com.josea.pruebafootters.UI.Entities.Member;
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
        Call<BaseResponse<Member>> call = apiModule.getMember();
        call.enqueue(new Callback<BaseResponse<Member>>() {
            @Override
            public void onResponse(Call<BaseResponse<Member>> call, Response<BaseResponse<Member>> response) {
                if (response.code()==200){
                    callBack.onSuccessMember(response.body().getData());
                }else{
                    callBack.onErrorMember(response.code());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Member>> call, Throwable t) {
                callBack.onErrorMember(-1);
            }
        });
    }
}
