## 平台简介 
辣鸡商城

## 技术选型
### 1、系统环境
- Java EE 8
- Servlet 3.0
- Apache Maven 3

### 2、主框架

- Spring Boot 2.3.x
- Spring Cloud Hoxton.SR9
- Spring Framework 5.2.x
- Spring Security 5.2.x

### 3、持久层

- Apache Mybatis-plus 3.1.x

## 系统模块
```
com.lj     
├── li-common          // 通用模块
│       └── lj-common-core                     // 通用服务
│       └── lj-common-log                      // 安全拓展服务
│       └── lj-common-redis                    // 缓存服务
├── lj-modules         // 业务模块
│       └── lj-admin                           // 链签署移动端模块 [9206]
│       └── lj-gen                             // 链签署PC端模块 [9205]
│       └── lj-shop                            // 银行对接模块 [9213]
├──pom.xml             // 公共依赖
```
