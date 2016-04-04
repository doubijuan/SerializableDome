package com.xiaolijuan.serializabledome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaolijuan.serializabledome.model.UserModel;


public class MainActivity extends Activity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void next() {
        //序列化过程
        UserModel userModel = new UserModel(0, "lijuan", true);
        Intent intent = new Intent(MainActivity.this,
                SecondActivity.class);
        intent.putExtra("userModel", userModel);
        startActivity(intent);
    }
}
