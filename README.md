# springboot-init
springboot 初始化模板


## 项目介绍
### Swagger 地址
###### 注意：不要在接口返回类上加 Swagger 注解（@Schema ），否则会导致所有接口文档都显示该类，但是识别不到里边的 泛型实体类
Swagger：http://localhost:8080/api/doc.html#/home  
Swagger UI：http://localhost:8080/api/swagger-ui/index.html  
Swagger JSON API：http://localhost:8080/api/v3/api-docs


# AI 大模型调用指南
## 星火大模型
### 选择请求的模型版本
- general 指向 Lite 版本；
- generalv3 指向 Pro 版本； 
- pro-128k 指向 Pro-128K 版本； 
- generalv3.5 指向 Max 版本； 
- 4.0Ultra 指向 4.0 Ultra 版本；

test 测试分支保护是否生效