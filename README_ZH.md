# 华为钱包服务客户端示例代码

## 目录

 * [简介](#简介)
 * [安装](#安装)
 * [环境要求](#环境要求)
 * [示例代码](#示例代码)
 * [授权许可](#授权许可)
 
 
## 简介
本示例代码调用华为钱包服务（HUAWEI Wallet Kit）客户端API，提供多个样例项目供您参考。

## 安装
-  检查安卓开发环境是否安装。
-  解压示例代码包。 
-  将解压后的项目导入Android Studio。
-  更新并同步项目。
-  在安卓真机或模拟机上运行测试应用。
    
## 环境要求
-  Android Studio 3.0及以上版本
-  ava JDK 1.8及以上版本
-  SDK Platform 26及以上版本
-  Gradle 4.6及以上版本
	
## 示例代码
示例代码提供两种卡券添加方式：通过伙伴应用、伙伴快应用、华为钱包CardStore领取卡券；通过伙伴应用、网页、短信、邮件领取卡券。

1. **通过伙伴应用、伙伴快应用、华为钱包CardStore领取卡券：**
目前仅适用于中国大陆。

- 申请华为钱包服务。
开发者需要申请华为钱包服务。设置服务号并生成证书用于加密卡券包。详情请参阅
[中文](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5) / [English](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5)

- 开发者用服务端示例代码生成一个卡券包
[服务端示例代码](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Examples-V5/java-sample-code-0000001050157448-V5)

- 将卡券包推送至华为钱包应用。
在TestUtil.java中重写createPassData()从而将该卡券包推送至华为钱包应用。示例代码中仅模拟卡券添加过程。在真实开发过程中，您需从您的服务器获取卡券和卡券包数据。

2. **通过伙伴应用、网页、短信、邮件领取卡券：**
- 申请华为钱包服务。
开发者需要申请华为钱包服务。设置服务号并生成一对RSA密钥，其中私钥用于加密JWE数据。详情请参阅：
[中文](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5) / [English](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5)

- 将模板推送至华为服务器
定义一个模板并将模板推送到华为服务器。详情请参阅：
[中文](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-webpage-0000001050042334-V5#ZH-CN_TOPIC_0000001050159047__section179891059101817) / [English](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-webpage-0000001050042334-V5#ZH-CN_TOPIC_0000001050159047__section179891059101817)

- 生成卡券实例并将其以JWE形式推送到华为服务器。
在Constant.java中填入之前生成的RSA私钥。该私钥用于加密JWE数据。推送成功后，用户可以在华为钱包中找到卡券。

## 技术支持
如果您对HMS Core还处于评估阶段，可在[Reddit社区](https://www.reddit.com/r/HuaweiDevelopers/)获取关于HMS Core的最新讯息，并与其他开发者交流见解。

如果您对使用HMS示例代码有疑问，请尝试：
- 开发过程遇到问题上[Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services)，在`huawei-mobile-services`标签下提问，有华为研发专家在线一对一解决您的问题。
- 到[华为开发者论坛](https://developer.huawei.com/consumer/cn/forum/blockdisplay?fid=18) HMS Core板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/HMS-Core/hms-wallet-clientdemo-android/issues)，也欢迎您提交[Pull Request](https://github.com/HMS-Core/hms-wallet-clientdemo-android/pulls)。

##  授权许可
华为钱包服务客户端示例代码经过[Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0)授权许可.
