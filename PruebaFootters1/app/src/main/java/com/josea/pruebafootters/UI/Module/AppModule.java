package com.josea.pruebafootters.UI.Module;

import com.josea.pruebafootters.UI.Main.Interactor.MainInteractor;
import com.josea.pruebafootters.UI.Main.Interactor.MainInteractorImpl;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenter;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenterImpl;
import com.josea.pruebafootters.UI.Main.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ConnectionModule.class})
public class AppModule {
    private MainActivity mainActivity;

    public AppModule(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }



    //presenter
    @Provides
    MainPresenter mainPresenter(MainPresenterImpl presenter){
        return presenter;
    }

    //interactor
    @Provides
    MainInteractor mainInteractor(MainInteractorImpl interactor){
        return interactor;
    }
}


