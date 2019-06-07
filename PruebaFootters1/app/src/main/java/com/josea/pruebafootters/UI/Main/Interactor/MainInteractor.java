package com.josea.pruebafootters.UI.Main.Interactor;

import com.josea.pruebafootters.UI.Entities.Member;

import java.util.List;

public interface MainInteractor {
    void getMembersOrg(OngetMembersOrg callBack);
    interface OngetMembersOrg{
        void onSuccessMember(List<Member> data);
        void onErrorMember(int code);
    }
}
