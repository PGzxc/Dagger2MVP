package com.example.dagger2mvp.dragger.module;

import com.example.dagger2mvp.view.ILoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/12/12.
 */

@Module
public class MainModule {

    private  final ILoginView view;

    public MainModule(ILoginView view) {
        this.view = view;
    }

    @Provides
    public ILoginView provideILogView() {
        return view;
    }
}
