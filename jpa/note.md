# 踩坑记录



### 1. JPA+MySql配置

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <!--最好指定版本号-->
    <version>8.0.19</version>
    <scope>runtime</scope>
</dependency>
```

## 2. persistence.xml文件配置注意点

1. ** 注意ibernate.dialect**使用的版本和MySql对应
2. 数据库的基本配置注意hibernate对应的版本，这是新版的配置，有些教程上的不一定能用

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
    http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd" version="2.0">
    <persistence-unit name="myJpa" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <!-- 必须配置，需要注意一下版本的区别 -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://数据库地址"/>
            <property name="javax.persistence.jdbc.user" value="pbsage"/>
            <property name="javax.persistence.jdbc.password" value="123456"/>
            
             <!-- 方言：数据库提供商对SQL的扩展 -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>
            <!-- 可选配置 -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="create"/>
        </properties>
    </persistence-unit>
</persistence>

```



