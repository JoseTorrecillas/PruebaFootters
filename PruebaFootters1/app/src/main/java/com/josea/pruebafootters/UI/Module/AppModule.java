package com.josea.pruebafootters.UI.Module;

import com.josea.pruebafootters.UI.Main.Interactor.MainInteractor;
import com.josea.pruebafootters.UI.Main.Interactor.MainInteractorImpl;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenter;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenterImpl;
import com.josea.pruebafootters.UI.Main.Views.MainView;
import com.josea.pruebafootters.UI.Main.ui.MainActivity;
import com.josea.pruebafootters.UI.User.Interactor.RepositoryInteractor;
import com.josea.pruebafootters.UI.User.Interactor.RepositoryInteractorImpl;
import com.josea.pruebafootters.UI.User.Presenter.RepositoryPresenter;
import com.josea.pruebafootters.UI.User.Presenter.RepositoryPresenterImpl;
import com.josea.pruebafootters.UI.User.Views.MemberUserView;
import com.josea.pruebafootters.UI.User.ui.MemberActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ConnectionModule.class})
public class AppModule {
    private MainActivity mainActivity;
    private MemberActivity memberActivity;

    public AppModule(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    public AppModule(MemberActivity memberActivity) {
        this.memberActivity=memberActivity;
    }


    //presenter
    @Provides
    MainPresenter mainPresenter(MainPresenterImpl presenter){
        return presenter;
    }

    @Provides
    RepositoryPresenter repositoryPresenter(RepositoryPresenterImpl presenter){
        return presenter;
    }

    //interactor
    @Provides
    MainInteractor mainInteractor(MainInteractorImpl interactor){
        return interactor;
    }

    @Provides
    RepositoryInteractor repositoryInteractor(RepositoryInteractorImpl interactor){
        return  interactor;
    }

    //view
    @Provides
     public MainView mainView(){
        return mainActivity;
    }

    @Provides
    MemberUserView memberUserView(){
        return memberActivity;
    }
}


