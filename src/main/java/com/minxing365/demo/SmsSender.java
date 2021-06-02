package com.minxing365.demo;

import com.minxing365.service.sdk.SmsSendService;
import org.apache.log4j.Logger;

/**
 * @author SuZZ on 2019-01-09.
 */
public class SmsSender implements SmsSendService {

    private Logger logger = Logger.getLogger(SmsSender.class);



    /**
     * 发送短信
     *
     * @param mobile  手机号
     * @param content 内容
     * @return 是否发送成功
     */
    @Override
    public boolean sendMessage(String mobile, String content) {
        try {
//            logger.info("send sms sender to mobile is " + mobile + " and content is " + content);
//            //组装请求对象-具体描述见控制台-文档部分内容
//            SendSmsRequest request = new SendSmsRequest();
//            //必填:待发送手机号
//            request.setPhoneNumbers(mobile);
//            //必填:短信签名-可在短信控制台中找到
//            request.setSignName(signName);
//            //必填:短信模板-可在短信控制台中找到
//            request.setTemplateCode(templateCode);
//            // 截取出验证码
//            String code = content.substring(0, content.indexOf(","));
//            logger.info("sms code is " + code);
//            // 短信模板变量
//            request.setTemplateParam(String.format(TEMPLATE_PARAM,code));
//            //hint 此处可能会抛出异常，注意catch
//            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//            logger.info("get sms send response is " + sendSmsResponse.getCode());
//            if (sendSmsResponse.getCode().equalsIgnoreCase("ok")){
//                return true;
//            } else {
//                return false;
//            }
            return true;
        } catch (Exception e) {
            logger.error("Error in send message" ,e);
        }
        return false;
    }

    /**
     * 初始化
     */
    @Override
    public void init() {
        logger.info("Start to init sms sender");
//        //初始化配置读取
//        accessKeyId = PropertiesUtils.getValue("sms.access.key.id");
//        logger.info("get sms sender access key id is " + accessKeyId);
//        accessKeySecret = PropertiesUtils.getValue("sms.access.key.secret");
//        logger.info("get sms sender access key secret is " + accessKeySecret);
//        signName = PropertiesUtils.getValue("sms.sender.signName");
//        logger.info("get sms sender signName is " + signName);
//        templateCode = PropertiesUtils.getValue("sms.sender.template.code");
//        logger.info("get sms sender template code is " + templateCode);
//        //可自助调整超时时间
//        System.setProperty("sun.net.client.defaultConnectTimeout", PropertiesUtils.getString("sms.sender.connect.timeout", "10000"));
//        System.setProperty("sun.net.client.defaultReadTimeout", PropertiesUtils.getString("sms.sender.read.timeout", "10000"));
//        logger.info("read config complete, start to init");
//        try {
//            //初始化acsClient,暂不支持region化
//            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
//                    accessKeySecret);
//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//            acsClient = new DefaultAcsClient(profile);
//        } catch (Exception e) {
//            logger.error("Error in init sms sender", e);
//        }
    }

    /**
     * 发布
     */
    @Override
    public void release() {

    }

    public static void main(String args[]) throws Exception{
        SmsSender smsSender = new SmsSender();
        smsSender.init();
    }

}