# HMS Walletkit Sample

## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Configuration ](#configuration )
 * [Supported Environments](#supported-environments)
 * [Sample Code](#sample-code)
 * [License](#license)
 
 
## Introduction
This sample code invokes HUAWEI Wallet Kit client APIs. It provides many sample methods for your reference or usage.

## Installation
Before using the sample code, check whether the android environment has been installed.
Decompress the sample code package.
    
Import the decompressed project to your Android Studio.
Refresh and sync the project.
Run the sample on Android device or emulator.
    
## Supported Environments
Android Studio 3.X
Java JDK(1.8 or later)
SDK Platform(26 or later)
Gradle(4.6 or later)
	
## Configuration 
NA
	
## Sample Code
The sample code provides two methods for adding passes: Claiming passes by app, quick app, or HUAWEI Wallet CardStore and Claiming passes by web page, SMS message, email, or app.

1. "Claiming passes by app, quick app, or HUAWEI Wallet CardStore":
Currently, this mode is available only in the Chinese mainland.

1). Applying for the Wallet Kit Service.
Developers need to apply for the Wallet Kit Service. You should apply for a service ID and obtain a certificate, which is used to encrypt pass package.

Chinese: https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5.

English: https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5.

2). The developer uses the server demo to generate a pass package.
A developer needs to generate a voucher package using the server demo.
For details about how to generate voucher packages using the server demo, see (huawei-wallet-server-windows-passsdk-demo.zip): https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Examples-V5/java-sample-code-0000001050157448-V5.

3). Push the pass package to the Huawei Pay app.
The developer replaces createPassData() in TestUtil.java. This step is only used to simulate card adding. In the actual situation, the developer needs to obtain the card and pass package data from the developer server.

2."Claiming passes by web page, SMS message, email, or app":
1). Applying for the Wallet Kit Service.
Developers need to apply for the Wallet Kit Service. You should apply for a service ID and generate a pair of RSA keys (the private key is used to encrypt JWE data).

Chinese: https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5.

English: https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-agc-overview-0000001050158420-V5.

2). Push models to Huawei servers.
This step needs to be performed before the developer uses the demo to add pass instances. For details, see the development guide.

Chinese: https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/guide-webpage-0000001050042334-V5#ZH-CN_TOPIC_0000001050159047__section179891059101817.

English: https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/guide-webpage-0000001050042334-V5#ZH-CN_TOPIC_0000001050159047__section179891059101817

3) Use the demo to convert a pass instance into JWE and push the JWE to the Huawei server.
Developers need to replace the private key in Constant.java. The private key is obtained from step 1. The private key is used to encrypt JWE data. After JWE data is generated, it can be pushed to Huawei servers. After the push is successful, users can view the pass card in Huawei Pay.

##  License
Wallet Kit SDK sample is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

## Question or issues
If you want to evaluate more about HMS Core,
[r/HMSCore on Reddit](https://www.reddit.com/r/HuaweiDevelopers/) is for you to keep up with latest news about HMS Core, and to exchange insights with other developers.

If you have questions about how to use HMS samples, try the following options:
- [Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services) is the best place for any programming questions. Be sure to tag your question with 
`huawei-mobile-services`.
- [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home?fid=0101187876626530001) HMS Core Module is great for general questions, or seeking recommendations and opinions.

If you run into a bug in our samples, please submit an [issue](https://github.com/HMS-Core/hms-scan-demo/issues) to the Repository. Even better you can submit a [Pull Request](https://github.com/HMS-Core/hms-scan-demo/pulls) with a fix.
