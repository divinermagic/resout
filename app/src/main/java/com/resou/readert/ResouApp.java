package com.resou.readert;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import static org.android.agoo.common.d.TAG;

public class ResouApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "5b1a4f378f4a9d0fb3000198", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
                "62a46dd8cd61c16da081d31b6a1ec386");

        PushAgent mPushAgent = PushAgent.getInstance(this);
        UMConfigure.setLogEnabled(true);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e(TAG, "deviceToken: " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG, "onFailure s: " + s + "\ns1: " + s1);

            }
        });
    }
}
