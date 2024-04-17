## 项目结构

![image.png](https://cdn.nlark.com/yuque/0/2024/png/120265/1713365293165-1b051854-2c9d-4fe4-84c0-9a22af077f1f.png#averageHue=%2331353c&clientId=ubf8b307a-f7c0-4&from=paste&height=228&id=ua51f9f16&originHeight=456&originWidth=550&originalType=binary&ratio=2&rotation=0&showTitle=false&size=48255&status=done&style=none&taskId=u026e261c-3a6a-421e-93b5-18a8c504e27&title=&width=275)

### 基础组件库(libs)

#### network

> 网络层，封装Retrofit、OkHttp等

#### utils

> 封装常用的工具类

#### common

> - 支撑业务组件、功能组件的基础（BaseActivity/BaseFragment等)基础能力。
> - 依赖基础组件，如network、utils等。
> - 业务组件、功能组件所需的基础能力只需要依赖common组件即可获得。

### 业务 | 功能组件(features)

#### login

> 登录业务组件

#### mine

> 个人信息业务组件

#### payment

> 支付组件

#### share

> 分享组件

### 主工程（app）

> 程序入口，只依赖业务组件。

