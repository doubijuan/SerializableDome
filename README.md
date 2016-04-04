#Android中Intent传递类对象的方法一(Serializable)
###Activity之间通过Intent传递值，支持基本数据类型和String对象及它们的数组对象byte、byte[]、char、char[]、boolean、boolean[]、short、short[]、int、int[]、long、long[]、float、float[]、double、double[]、String、String[]，还有实现了Serializable、Parcelable接口的类对象。

###实现Serializable接口和实现Parcelable接口传递类对象的方法分别是： 
###（1）Bundle.putSerializable(Key,Object); 
###（2）Bundle.putParcelable(Key, Object);

###实际上Serializable和Parcelable接口都是可以完成对象的序列化过程，所以当我们需要通过Intent或者Binder传输数据的时候就需要使用Parcelable或者Serialization。还有一些时候我们需要把对象持久化到存储设备上或者通过网络传输给其他客户端等都需要使用到Serialization来完成对象的持久化。

###我们简单看一下第一种方法：Serialization接口

###我新建了一个UserModel.java类实现了Serializable接口，使用Serialization实现序列化特别简单，只需要这个类实现Serialization接口并声明一个serialVersionUID 即可。
```Java
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
```
####实际上，serialVersionUID 也不是必需的，我们不声明这个serialVersionUID 同样也可以实现序列化，但是这个会对反序列化过程造成影响，具体就不详细介绍了。

####接着我们在MainActivity.java中传递实现了Serializeable接口的UserModel对象
```Java
 //序列化过程
        UserModel userModel = new UserModel(0, "lijuan", true);
        Intent intent = new Intent(MainActivity.this,
                SecondActivity.class);
        intent.putExtra("userModel", userModel);
        startActivity(intent);
```
####现在在SecondActivity.java中就可以接收到从MainActivity.java传递过来的UserModel啦
```Java
//反序列化过程
        UserModel userModel = (UserModel) getIntent()
                .getSerializableExtra("userModel");
        Log.e("TAG", "用户Id：" + userModel.getUserId() + "，用户名：" + userModel.getUserName() + "，男生？" + userModel.isMale());
```
####此时在日志中就会打印出我们这行信息啦
```Java
04-03 23:38:56.020  10596-10596/com.xiaolijuan.serializabledome E/TAG﹕ 用户Id：0，用户名：lijuan，男生？true
```
