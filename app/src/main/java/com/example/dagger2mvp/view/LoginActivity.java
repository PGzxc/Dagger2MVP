package com.example.dagger2mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dagger2mvp.R;
import com.example.dagger2mvp.dragger.component.DaggerMainComponent;
import com.example.dagger2mvp.dragger.module.MainModule;
import com.example.dagger2mvp.present.LoginPresenterCompl;

import javax.inject.Inject;

/**
 * Created by admin on 2017/12/12.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private Button mLogin ;
    private Button mClear ;
    private EditText mName ;
    private EditText mPassWord ;

    @Inject
    LoginPresenterCompl loginPresenterCompl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = findViewById(R.id.btn_login);
        mClear = (Button) findViewById(R.id.btn_clear);
        mName =  findViewById(R.id.et_name);
        mPassWord =  findViewById(R.id.et_password);

        mLogin.setOnClickListener(this);
        mClear.setOnClickListener(this);

        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);


    }

    @Override
    public void onClearText() {
        mName.setText("");
        mPassWord.setText("");
        Toast.makeText(this,"clear",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLogin.setEnabled(true);
        mClear.setEnabled(true);

        if(result){
            Toast.makeText(this,"登陆成功: "+code,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登陆失败："+code,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        String name = mName.getText().toString() ;
        String password = mPassWord.getText().toString() ;

        switch (id){
            case R.id.btn_login :
                loginPresenterCompl.doLogin(name,password);
                break ;
            case R.id.btn_clear :
                loginPresenterCompl.clear();
                break;
        }
    }
}
