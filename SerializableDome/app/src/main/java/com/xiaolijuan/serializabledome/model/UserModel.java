package com.xiaolijuan.serializabledome.model;

import java.io.Serializable;

/**
 * @author: xiaolijuan
 * @description:
 * @date: 2016-04-03
 * @time: 21:23
 */
public class UserModel implements Serializable{

    private static final long serialVersionUID = 6465198351058235015L;

    public int userId;
    public String userName;
    public boolean isMale;

    public UserModel(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
}
