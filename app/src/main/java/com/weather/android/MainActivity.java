package com.weather.android;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weather.android.db.User;

import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edt_username)
    EditText username;
    @BindView(R.id.edt_password)
    EditText password;
    @BindView(R.id.login_btn_login)
    Button login;
    @BindView(R.id.login_btn_register)
    Button register;

    Fragment chooseAreaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        chooseAreaFragment = (android.support.v4.app.Fragment)findViewById(R.id.choose_area_fragment);
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        if(prefs.getString("weather",null) != null){
//            Intent intent = new Intent(this, WeatherActivity.class);
//            startActivity(intent);
//            finish();
    }

    List<User> userList;

    @OnClick({R.id.login_btn_login, R.id.login_btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                confirmLogin();
                break;
            case R.id.login_btn_register:
                Intent intent = new Intent(MainActivity.this, com.weather.android.register.class);
                startActivity(intent);
                break;
        }
    }

    private void confirmLogin() {
        userList = DataSupport.findAll(User.class);
        boolean a = false;
        Log.e("xx", String.valueOf(userList.size()));
        for(int i = 0; i < userList.size(); i++) {
            Log.e("user",userList.get(i).getPassword() + "++" + userList.get(i).getUsername());
            if(Objects.equals(userList.get(i).getPassword(), password.getText().toString())
                    && Objects.equals(userList.get(i).getUsername(), username.getText().toString())) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if (prefs.getString("weather", null) != null) {
                    Intent intent = new Intent(this, WeatherActivity.class);
                    startActivity(intent);
//                    finish();
            }else {
                    Intent intent = new Intent(this,ChooseArea.class);
                    startActivity(intent);
                    finish();
                }
                a = true;
            }
        }
        String b;
        if(a){
            b = "登陆成功";
        }else{
            b = "账号密码输入错误";
        }
        Toast.makeText(this, b, Toast.LENGTH_SHORT).show();
    }
}
