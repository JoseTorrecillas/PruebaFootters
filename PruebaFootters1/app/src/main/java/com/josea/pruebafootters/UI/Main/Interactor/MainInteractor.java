package com.josea.pruebafootters.UI.Main.Interactor;

import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.User;

import java.util.List;

public interface MainInteractor {
    void getMembersOrg(OngetMembersOrg callBack);

    void getUser(String url,OngetUser callBack);

    interface OngetMembersOrg{
        void onSuccessMember(List<Member> data);
        void onErrorMember(int code);
    }

    interface OngetUser{
        void onSuccesUser(User user);
        void onErrorUser(int code);
    }
}
