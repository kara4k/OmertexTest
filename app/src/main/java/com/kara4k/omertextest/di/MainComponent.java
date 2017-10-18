package com.kara4k.omertextest.di;

import com.kara4k.omertextest.di.modules.MainModule;
import com.kara4k.omertextest.di.scopes.PerActivity;
import com.kara4k.omertextest.view.MainActivity;

import dagger.Component;


@PerActivity
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void injectMainActivity(MainActivity activity);
}
