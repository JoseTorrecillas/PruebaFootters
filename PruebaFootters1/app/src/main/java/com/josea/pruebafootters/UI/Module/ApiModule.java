package com.josea.pruebafootters.UI.Module;

import com.josea.pruebafootters.UI.Entities.BaseResponse;
import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.Repository;
import com.josea.pruebafootters.UI.Entities.User;
import com.josea.pruebafootters.UI.Utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
public interface ApiModule {

    @GET(Constants.WALLAPOPMEMBER)
    Call<List<Member>> getMember();

    @GET()
    Call<User> getUser(@Url String login);

    @GET()
    Call<List<Repository>> getRepositories(@Url String urlRepositories);

}
