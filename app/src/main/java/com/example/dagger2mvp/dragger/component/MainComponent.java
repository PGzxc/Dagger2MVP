package com.example.dagger2mvp.dragger.component;

import com.example.dagger2mvp.dragger.module.MainModule;
import com.example.dagger2mvp.view.LoginActivity;

import dagger.Component;

/**
 * Created by admin on 2017/12/12.
 */

@Component(modules = MainModule.class)
public interface  MainComponent {
    public  void inject(LoginActivity activity);
}
