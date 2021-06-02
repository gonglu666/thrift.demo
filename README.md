# 说明
该项目是java工程，maven项目。使用开发工具导入项目。

# 编写类
## 第三方登陆
参考demo类，DemoAccountAuthenticationService，继承com.minxing365.service.sdk.AccountAuthenticationService

## 短信验证
参考demo类，SmsSender.java，继承
SmsSendService

# 修改配置文件
config/application.properties
account.valid_account.classname=自己实现的类，带着包名
sms.send_service.classname=自己实现的类，带着包名


# 打包
编译打包成tar.gz
能执行sh命令的电脑，可以直接在该工程目录下执行 ./build.sh thirdextension 1.0.0
如果是windows电脑，参考build.txt，打包出thirdextension_1.0.0.tar.gz


# 部署
上传到服务器里后，解压，使用root执行./install.sh进行安装
如果install.sh没有执行权限， 可以chmod增加一下

# 启动
/etc/init.d/mx_thrift_server [start|stop|restart]

# 日志
/home/ewhine/var/log/mx_thrift_server/mx_thrift_server.log

# 设置使用第三方登陆
admin登陆系统管理页面，身份认证的地方，选择第三方认证
# 短信验证码登陆
app客户端打包做配置，改成短信验证码登陆方式