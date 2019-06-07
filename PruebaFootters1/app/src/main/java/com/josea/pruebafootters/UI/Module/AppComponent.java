package com.josea.pruebafootters.UI.Module;

import com.josea.pruebafootters.UI.Main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
