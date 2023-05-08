# Conditional

앞서 **02.SpringBoot BEAN 구성원리**에서는 Condition을 구현한 클래스에서 matches 메서드를 Override해서 리턴값에 따라 구성하였지만, 이를 더 커스터마이징하게 만들 수 있다.

## **✔️ 커스터마이징하게 Conditional과 Condition을 이용하여 Jetty Server만 띄워보기**

### **1. pom.xml**

```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jetty</artifactId>
		</dependency>
```

exclusions와 exclusion 태그를 통해 tomcat을 제외 시킨다.

### **2. tobyspring.config.RwkAutoConfiguration.import**

- Before

```
tobyspring.config.autoconfig.DispatcherServletConfig
tobyspring.config.autoconfig.TomcatWebServerConfig
tobyspring.config.autoconfig.JettyWebServerConfig
```

- after

```
tobyspring.config.autoconfig.DispatcherServletConfig
tobyspring.config.autoconfig.JettyWebServerConfig
```

Jetty를 띄울 것이므로, tobyspring.config.autoconfig.TomcatWebServerConfig를 지워준다.


### **3. RwkonClassCondition**

```java
public class RwkOnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalRwkOnClass.class.getName());
        String value = (String) attrs.get("value");
        // 해당하는 이름의 클래스가 존재하지 않으면  false, 존재하면 true 리턴
        return ClassUtils.isPresent(value, context.getClassLoader());
    }
}
```

Condition 인터페이스를 구현한 클래스를 작성하여 해당하는 이름의 클래스의 존재 여부에 따라, true와 false를 리턴한다.

### **4. ConditionalRwkOnClass**

```java

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(RwkOnClassCondition.class)
public @interface ConditionalRwkOnClass {
    String value();
}
```

RwkOnClassCondition 클래스를 @Conditional 속성값으로 등록한다.

### **5. TomcatWebServerConfig**

```java
@Configuration
@ConditionalRwkOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}
```

기존의 static class TomcatCondition을 제거하고 @ConditionalRwkOnClass 메타 어노테이션의 속성값으로 "org.apache.catalina.startup.Tomcat"를 등록해준다.

### **6. JettyWebServerConfig**

```java
@RwkAutoConfiguration
@ConditionalRwkOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory(){
        return new JettyServletWebServerFactory();
    }
}
```
JettyWebServerConfig에서도 마찬가지로 기존의 static class JettyCondition을 제거하고
 @ConditionalRwkOnClass 메타 어노테이션의 속성값으로 "org.eclipse.jetty.server.Server"를 등록해준다. 


### **7. HelloBootApplication 실행 결과**

![image](https://user-images.githubusercontent.com/81727895/236860036-c88a3def-bcf0-4f9b-8467-d8ee6a35aab3.png)


### **8. httpie 테스트**

![image](https://user-images.githubusercontent.com/81727895/236860652-789897be-9101-40be-8a2a-c27bfc6794bc.png)

Jetty 서버를 띄운 뒤, 성공적으로 Request와 Response가 정상적으로 작동한다.