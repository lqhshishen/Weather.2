package com.weather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by liqihao on 2017/11/27.
 */

public class User extends DataSupport {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
