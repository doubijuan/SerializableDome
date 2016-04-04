package com.xiaolijuan.serializabledome;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.xiaolijuan.serializabledome.model.UserModel;

/**
 * @author: adan
 * @description:
 * @date: 2016-04-03
 * @time: 21:36
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //反序列化过程
        UserModel userModel = (UserModel) getIntent()
                .getSerializableExtra("userModel");
        Log.e("TAG", "用户Id：" + userModel.getUserId() + "，用户名：" + userModel.getUserName() + "，是否是男性：" + userModel.isMale());
    }
}
