package com.josea.pruebafootters.UI.Module;

import com.josea.pruebafootters.UI.Entities.BaseResponse;
import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiModule {

    @GET(Constants.WALLAPOPMEMBER)
    Call<BaseResponse<Member>> getMember();

}
