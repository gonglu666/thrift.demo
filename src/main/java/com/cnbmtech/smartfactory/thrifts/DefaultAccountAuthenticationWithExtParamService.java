package com.cnbmtech.smartfactory.thrifts;

import com.alibaba.fastjson.JSONObject;
import com.cnbmtech.smartfactory.thrifts.utils.OauthUtils;
import com.minxing365.common.pojo.AccountAuthenticationInfo;
import com.minxing365.common.pojo.AccountAuthenticationResponse;
import com.minxing365.service.sdk.AccountAuthenticationWithExtParamService;
import com.minxing365.thrift.login_result;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * Created by gonglu
 * 2021/6/2
 */
public class DefaultAccountAuthenticationWithExtParamService implements AccountAuthenticationWithExtParamService {

    private static Logger log = Logger.getLogger(DefaultAccountAuthenticationWithExtParamService.class);

    private static final String mobileFlag = "mobile";

    private OauthUtils oauthUtils = OauthUtils.getInstance();

    @Override
    public AccountAuthenticationResponse validate_with_params(String loginName, String password, String flag) {
        log.info("validAccount in >>>loginName=" + loginName + "; password=" + password);
        JSONObject result = null;
        AccountAuthenticationResponse accountAuthenticationResponse = null;
        if (!StringUtils.isEmpty(flag) && mobileFlag.equalsIgnoreCase(flag)) {
            result = oauthUtils.validCode(loginName,password);
        } else {
            result =oauthUtils.validAccount(loginName,password);
        }
        log.info(JSONObject.toJSONString(result));
        if("9001".equals(result.getString("code"))){
            accountAuthenticationResponse = new AccountAuthenticationResponse(true,JSONObject.toJSONString(result),new AccountAuthenticationInfo());
        }else {
            accountAuthenticationResponse = new AccountAuthenticationResponse(false,JSONObject.toJSONString(result),new AccountAuthenticationInfo());
        }
        return accountAuthenticationResponse;
    }

}
