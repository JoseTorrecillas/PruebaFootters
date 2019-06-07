package com.josea.pruebafootters.UI.Main.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.josea.pruebafootters.R;
import com.josea.pruebafootters.UI.Main.Presenter.MainPresenter;
import com.josea.pruebafootters.UI.Module.AppComponent;
import com.josea.pruebafootters.UI.Module.AppModule;
import com.josea.pruebafootters.UI.Module.DaggerAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInjection();
        mainPresenter.getMemberOrg();
    }

    private void initInjection() {
        AppComponent avppmComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        avppmComponent.inject(this);
    }

}
