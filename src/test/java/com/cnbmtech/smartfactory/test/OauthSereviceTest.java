package com.cnbmtech.smartfactory.test;

import com.cnbmtech.smartfactory.thrifts.DefaultAccountAuthenticationWithExtParamService;
import com.cnbmtech.smartfactory.thrifts.OauthSereviceImpl;
import com.minxing365.common.pojo.AccountAuthenticationResponse;
import com.minxing365.service.impl.DefaultAccountAuthenticationEnhanceService;
import com.minxing365.thrift.login_result;
import org.junit.Test;

public class OauthSereviceTest {
    @Test
    public void doTestLogin(){
        DefaultAccountAuthenticationWithExtParamService service = new DefaultAccountAuthenticationWithExtParamService();
        AccountAuthenticationResponse accountAuthenticationResponse = service.validate_with_params("yeyusheng", "qw111111", "qw111111");
        System.out.println("success");
    }
}
