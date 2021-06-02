package com.cnbmtech.smartfactory.test;

import com.cnbmtech.smartfactory.thrifts.OauthSereviceImpl;
import com.minxing365.service.impl.DefaultAccountAuthenticationEnhanceService;
import com.minxing365.thrift.login_result;
import org.junit.Test;

public class OauthSereviceTest {
    @Test
    public void doTestLogin(){
        DefaultAccountAuthenticationEnhanceService service = new  OauthSereviceImpl();
        login_result login_result = service.validAccount("houyinglang","180311");
        assert  login_result.result;
    }
}
