package com.cnbmtech.smartfactory.thrifts;

import com.alibaba.fastjson.JSONObject;
import com.cnbmtech.smartfactory.thrifts.utils.OauthUtils;
import com.minxing365.service.impl.DefaultAccountAuthenticationEnhanceService;
import com.minxing365.thrift.login_result;
import org.apache.log4j.Logger;

/**
 * 根据敏行提供的框架，编写用户登录验证功能
 * @author APTX-4869
 * @since 2020-08-18
 */
public class OauthSereviceImpl extends DefaultAccountAuthenticationEnhanceService {
    private static Logger log = Logger.getLogger(OauthSereviceImpl.class);

    private final String phoneTemp = "^1[3|4|5|7|8][0-9]{9}$";
    public  OauthUtils oauthUtils = OauthUtils.getInstance();
    @Override
    public login_result validAccount(String loginName, String password) {
        log.info("validAccount in >>>loginName=" + loginName + "; password=" + password);
        JSONObject result = null;
        login_result login_result = null;
        //检测loginName是否是手机号
        if(loginName.matches(phoneTemp)){
            // 验证码模式认证
            result = oauthUtils.validCode(loginName,password);
        }else{
            //账号密码模式认证
            result =oauthUtils.validAccount(loginName,password);
        }
        log.info(JSONObject.toJSONString(result));
        if("9001".equals(result.getString("code"))){
            login_result = new login_result(true,JSONObject.toJSONString(result));
        }else {
            login_result = new login_result(false,JSONObject.toJSONString(result));
        }
        return login_result;
    }


}
