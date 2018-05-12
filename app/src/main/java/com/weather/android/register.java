package com.weather.android;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weather.android.db.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class register extends AppCompatActivity {
    @BindView(R.id.register_edt_username)
    EditText username;
    @BindView(R.id.register_edt_password)
    EditText password;
    @BindView(R.id.register_edt_confirmpassword)
    EditText confirmpassword;
    @BindView(R.id.register)
    Button register;
//    @BindView(R.id.registertitle)
//    Toolbar registertitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.registertitle);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @OnClick(R.id.register)
    public void onViewClicked() {
        if(!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())){
            User user = new User();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.save();
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "密码账号格式错误", Toast.LENGTH_SHORT).show();
        }
    }
}
