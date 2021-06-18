package com.cnbmtech.smartfactory.thrifts.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.lang.Singleton;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author APTX-4869
 * @des 统一认证工具类
 */
public class OauthUtils {

    // api for proc
    public final static String url  = "https://login.gt.cn/auth/api/user/appgateway/authenticate";
    // api for test
//    public final static String url  = "http://am.gttest.com:60100/auth/api/user/appgateway/authenticate";
    public final static String appId  = "appPortal";
    public final static String secret  = "aa154f89da3c4edca0095c766143e825";
    private static OauthUtils instance = new OauthUtils();

    public static OauthUtils getInstance() {
        return instance;
    }

    /**
     *  用户名密码模式认证
     * @param loginName
     * @param password
     * @return JSONObject
     */
    public JSONObject validAccount(String loginName, String password) {
        return this.valid(loginName,password,"UsernamePassword");
    }

    /**
     *  短信验证码模式认证
     * @param phone
     * @param code
     * @return JSONObject
     */
    public JSONObject validCode(String phone, String code) {
        return this.valid(phone,code,"UsernameSM");
    }

    /**
     *  通用验证模式
     * @param username
     * @param password
     * @param authnMethod
     * @return JSONObject
     */
     private JSONObject valid(String username, String password,String authnMethod) {
        Map<String,String> request  = new HashMap<>();
        JSONObject result = null;
        request.put("appId", appId);
        request.put("userName", username);
        request.put("password", password);
        request.put("checkCode",password);
        request.put("authnMethod", authnMethod);
        request.put("secret", secret);

        Response response = HttpUtils.sendByPostMap(url,request);
        int code = response.code();
        if(code==200&&response.body()!=null){
            try {
                result = JSONObject.parseObject(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
                result = this.setErrorResult(code,"用户中心接口调用失败");
            }
        }else{
            result = this.setErrorResult(code,"用户中心接口调用失败");
     }
        return result;
    }


    private JSONObject setErrorResult(int code,String message){
        JSONObject error = new JSONObject();
        error.put("code",code);
        error.put("message",message);
        return error;
    }



}
