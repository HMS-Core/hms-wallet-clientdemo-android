# HMS Walletkit Clientdemo

## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Supported Environments](#supported-environments)
 * [Getting Started](#getting-started)
 * [Result](#result)
 * [License](#license)
 
 
## Introduction
Sample code encapsulates APIs of the HUAWEI Wallet Kit client. It provides many sample programs for your reference or usage.

## Installation
Before using sample code, check whether the android environment has been installed. 
Decompress the sample code package.
Import the decompressed project to your Android Studio.
Refresh and sync the project.
Run the sample on Android device or emulator.
    
## Supported Environments
Android Studio 3.X
Java JDK(1.8 or later)
SDK Platform(26 or later)
Gradle(4.6 or later)
	
## Getting Started
[Sample Code for Adding a Loyalty Card Through the SDK](https://developer.huawei.com/consumer/en/doc/development/HMS-Guides/wallet-guide-integratingsdk)

### Provide two ways to add cards.
### 1 Push JWE data to Huawei server, please refer to PassTestActivity.java, please go to [AGC website](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/guide-agc-overview-0000001050158420) to register service .
#### 1.1 Create a loyalty card instance.
For detailed information about the settings, please refer to the API reference, replace the private key in the Contants.java file, please refer to [Applying for Security Components](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/preparations-secret-0000001050158422)
#### 1.2 Convert the instance to a JWE.
You need to implement the function of converting a generated instance to a JSON string and then converting the JSON string to a JWE on your server.
#### 1.3 Create CreateWalletPassRequest.
#### 1.4 Create a Client instance.
#### 1.5 Create a task.
#### 1.6 Execute the task.
#### 1.7 Receive the loyalty card adding result.
### 2 Push the card package to Huawei wallet, please refer to WalletPassCnActivity.java, the current method only supports the mainland China region.
#### 2.1 Go to the [AGC website](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/config-agc-0000001050193505) to register the service.
#### 2.2 Call CanAddPass() to determine whether the current server can be added.
#### 2.3 After obtaining the card coupon package through the certificate and private key obtained from the AGC website, call the AddPass() interface to push the card coupon package to the Huawei wallet.

##  Result
After clicking the add button, it returns save success or other error codes. For error codes, please refer to the API documentation

## Question or issues
If you want to evaluate more about HMS Core,
[r/HMSCore on Reddit](https://www.reddit.com/r/HuaweiDevelopers/) is for you to keep up with latest news about HMS Core, and to exchange insights with other developers.

If you have questions about how to use HMS samples, try the following options:
- [Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services) is the best place for any programming questions. Be sure to tag your question with 
`huawei-mobile-services`.
- [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home?fid=0101187876626530001) HMS Core Module is great for general questions, or seeking recommendations and opinions.

If you run into a bug in our samples, please submit an [issue](https://github.com/HMS-Core/hms-wallet-clientdemo-android/issues) to the Repository. Even better you can submit a [Pull Request](https://github.com/HMS-Core/hms-wallet-clientdemo-android/pulls) with a fix.

##  License
Wallet Kit SDK sample is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

