## 平台简介 
佳禾科技数安云链平台

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
com.jiahe     
├── jiahe-common          // 通用模块
│       └── jiahe-common-redis                        // 缓存服务
│       └── jiahe-ylq-common-core                     // 通用服务
│       └── jiahe-ylq-common-security                 // 安全拓展服务
├── jiahe-modules         // 业务模块
│       └── jiahe-signature-mobile                    // 链签署移动端模块 [9206]
│       └── jiahe-signature-pc                        // 链签署PC端模块 [9205]
│       └── jiahe-ylq-bank                            // 银行对接模块 [9213]
│       └── jiahe-ylq-datasource                      // 链签署数据库模块 [9210]
│       └── jiahe-ylq-idao                            // 链签署接口模块
│       └── jiahe-ylq-payment                         // 链支付模块 [9211]
│       └── jiahe-ylq-gen                             // 代码生成模块 
│       └── jiahe-ylq-file                            // 文件系统模块 [9215]
│       └── jiahe-ylq-file-api                        // 文件系统接口模块
├──pom.xml                // 公共依赖
```
