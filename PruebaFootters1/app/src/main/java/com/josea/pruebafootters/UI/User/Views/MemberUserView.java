package com.josea.pruebafootters.UI.User.Views;

import com.josea.pruebafootters.UI.Entities.Repository;

import java.util.List;

public interface MemberUserView {
    void setRepositories(List<Repository> repositoryList);

    void failRepositories(int code);
}
