package com.example.dagger2mvp.present;

import com.example.dagger2mvp.module.User;
import com.example.dagger2mvp.view.ILoginView;

import javax.inject.Inject;

/**
 * Created by admin on 2017/12/12.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    private ILoginView loginView;
    private User user;

    @Inject
    public LoginPresenterCompl(ILoginView view){
        loginView=view;
        user=new User("name","password");
    }

    @Override
    public void clear() {
        loginView.onClearText();

    }

    @Override
    public void doLogin(String name, String password) {
        boolean result=false;
        int code=0;
        if(name.equals(user.getName())&&password.equals(user.getPassword())){
           result=true;
           code=1;

        }else {
            result=false;
            code=0;
        }
        loginView.onLoginResult(result,code);
    }
}
