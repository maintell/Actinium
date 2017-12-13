package com.v2ray.actinium.util;

import android.content.Context;

import com.huawei.android.pushagent.PushManager;

/**向服务器请求Token
 * 前提是已经在华为开发者联盟注册本应用，并申请、审核通过Push权益
 * Created by Administrator on 2017/12/12.
 */

public class HwPushManager {
    private static HwPushManager mPushManager;
    private Context mContext;

    private HwPushManager(Context mContext){
        this.mContext = mContext;
    }

    public static  HwPushManager getInstance(Context mContext){
        if(mPushManager == null){
            mPushManager = new HwPushManager(mContext);
        }
        return mPushManager;
    }

    /**向服务器请求Token
     * 前提是已经在华为开发者联盟注册本应用，并申请、审核通过Push权益
     * */
    public void startRequestToken(){
        PushManager.requestToken(mContext);
    }

    /**
     * 是否接收服务器传递过来的透传消息
     * */
    public void isEnableReceiveNormalMsg(boolean isEnable){
        PushManager.enableReceiveNormalMsg(mContext,isEnable);
    }

    /**
     * 是否接收自呈现消息
     * */
    public  void isEnableReceiverNotifyMsg(boolean isEnable){
        PushManager.enableReceiveNotifyMsg(mContext,isEnable);
    }

}