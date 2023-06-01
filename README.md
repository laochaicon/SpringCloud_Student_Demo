# QCDP-demo

## 介绍

基于spring cloud的微服务后台  
由云南渠成科技有限公司搭建，并以此为基础开发相关业务应用系统。本项目仅作为开发测试和演示使用。

## 上手及运行教程

#### 运行本项目

1. 从gitee获取项目代码及相关资料；
2. 在开发工具中打开获取的代码，运行DemoApiApplication
3. 在浏览器中访问swagger，地址：http://localhost:8888/swagger-ui.html#/

#### 数据库创建

1. 安装mysql数据库，使用\docs\db\qcdp-demo.sql进行建表；
2. 数据库中各表的数据可使用接口进行添加或直接在表中进行添加；

#### 相关资料及说明

1. 数据库表结构文档：\docs\db\demo.pdma.json；请使用PDManer打开查看；
2. 接口定义：请先注册好apifox账号，并提供邮箱地址进行邀请加入“demo项目”；

## 开发测试要求

1. 功能要求：根据apifox中的接口定义，完成“学生-Student”下6个接口和“班级-Class”下1个接口的编写工作；
2. 开发要求：参照项目中已有的“用户-User”和“部门-Dept”模块开发，包含分层结构、类和方法定义等；
3. 时间要求：要求在任务下达后2天内完成，并在apifox中完成各接口的测试；
4. 代码管理要求：请自行在gitee上注册账号，将代码托管到gitee中；在保证代码可正常运行前提下，每完成1个接口进行1次代码的提交；
5. 工作成果要求：编写完成后在apifox中对各接口进行实测演示，在gitee中对仓库各版本差异进行在线查看；

## 编码步骤

1. DTO定义：对照apifox中的定义；
2. Controller定义：对照apifox中的定义；
3. Entity定义：可使用PDManer生成并进行适当修改；
4. Service、Repository和Mapper定义；
5. 具体业务逻辑编写：主要在Service和Mapper；

## 编码规范

### 通用规范

#### 命名规范

1. 文件夹名称全部使用小写命名；文件夹使用单个单词，不要使用2个及以上单词组合。
2. 文件名称使用首字母大写的驼峰式命名，第一个单词首字母大写。
3. 方法使用首字母大写的驼峰式命名，第一个单词所有字母均使用小写。方法名必须为动词或以动词开头命名。

#### Controller和Service中的方法规范

1. 方法中非预期错误或异常，不要进行捕获。
2. 方法中可能出现的预期错误或异常（如输入的字符串需要转换为日期时间时转换错误），使用抛出QCPromptException异常进行处理。
3. 对数据进行操作（新增、修改、删除等操作）返回类型定义为String类型，统一使用返回null表示成功，返回成功使用如下代码： return QCUnifyReturnValue.Success();
4. 如方法中返回非null字符串表示成功，使用如下代码： return QCUnifyReturnValue.Success(“成功结果信息”);
5. 方法中出现的预期错误或异常，不使用抛出QCPromptException异常，直接返回其他信息表示错误或提示信息，如有效性校验不通过使用QCUnifyReturnValue.Warn方法返回结果。

#### DTO层

1. DTO类上添加@Data注解；

#### Entity层

1. Entity类上添加@Data注解；

#### Api层

1. 注解；

#### Service层

1. 注解；

#### Repository层

1. 注解；

#### Mapper层

1. 注解；