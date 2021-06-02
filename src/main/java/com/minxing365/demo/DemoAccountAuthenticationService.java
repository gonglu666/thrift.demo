package com.minxing365.demo;

import com.minxing365.service.sdk.AccountAuthenticationService;
import org.apache.log4j.Logger;

public class DemoAccountAuthenticationService implements AccountAuthenticationService {
    private static Logger log = Logger.getLogger(DemoAccountAuthenticationService.class);

    @Override
    public boolean validAccount(String loginName, String password) {
        log.info("DemoAccountAuthenticationService开始调用第三方登录逻辑>>>loginName=" + loginName + "; password=" + password);
        // TODO: 2019/1/3 调用第三方业务逻辑，如果成功返回true，否则返回false
        return true;
    }
}
