# Cottage 用户中心
完整了解项目思路，接触企业级开发技术，制作管理系统可复用框架

### 项目流程
需求分析 => 设计 => 技术选型(JAVA\GO\C++) => 初始化/引入需要的技术 => 写demo => 写代码实现业务逻辑 => 单元测试 => 代码提交/评审 => 部署 => 发布

### 需求分析
1. 登陆/注册
2. 用户管理(仅管理员可见)
3. 用户校验

### 技术选型
前端：三件套 + React框架 + Ant_Design组件库 + Umi + AntD_Pro

后端：
- Java 
- spring(管理Java对象)
- springMVC(web框架，提供接口访问，restFul能力) 
- mybatis(持久层框架，对jdbc的封装)
- mybatis-plus(对mybatis的增强，支持代码自动生成)
- springboot 
- mysql

部署：服务器/容器(平台)

### 开发计划
1. 初始化项目
	1. 前端初始化
	   1. 初始化项目
       2. 引入组件
       3. 框架瘦身
	2. 后端初始化
       1. 准备环境 mysql
       2. 整合框架
2. **登陆/注册**
	1. 前端
	2. 后端
3. **用户管理**
	1. 前端
	2. 后端

### 逻辑删除
- 逻辑删除：删除数据时，不真正删除，而是修改状态
使用mybatis-plus的@TableLogic注解，在model层的原型类中对逻辑标识字段进行注解，在mapper层对逻辑删除字段进行注解
在扫描到该注解后，会将delete语句改为update语句，并根据注解中的delval值对该字段设置新的值

### logback.xml 配置文件
- 可配置日志输出路径、格式等自定义项