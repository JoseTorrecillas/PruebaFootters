package com.josea.pruebafootters.UI.Main.Views;

import com.josea.pruebafootters.UI.Entities.Member;
import com.josea.pruebafootters.UI.Entities.User;

import java.util.List;

public interface MainView {
    void setMembers(List<Member> data);

    void failMember(int code);

    void addUser(User user);

    void failUser(int code);

}
