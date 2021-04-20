Start:

```
docker-compose up -d
// wait until keycloak is up and running (check http://localhost:9990 is up)
./gradlew bootRun
```
Error:

```
2021-04-20 15:16:29.623  WARN 6256 --- [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'jwtDecoderByIssuerUri' defined in class path resource [org/springframework/boot/autoconfigure/security/oauth2/resource/reactive/ReactiveOAuth2ResourceServerJwkConfiguration$JwtConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.oauth2.jwt.ReactiveJwtDecoder]: Factory method 'jwtDecoderByIssuerUri' threw exception; nested exception is java.lang.ClassCastException: class com.nimbusds.jose.Algorithm cannot be cast to class com.nimbusds.jose.JWSAlgorithm (com.nimbusds.jose.Algorithm and com.nimbusds.jose.JWSAlgorithm are in unnamed module of loader 'app')
2021-04-20 15:16:29.634  INFO 6256 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2021-04-20 15:16:29.644 ERROR 6256 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'jwtDecoderByIssuerUri' defined in class path resource [org/springframework/boot/autoconfigure/security/oauth2/resource/reactive/ReactiveOAuth2ResourceServerJwkConfiguration$JwtConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.oauth2.jwt.ReactiveJwtDecoder]: Factory method 'jwtDecoderByIssuerUri' threw exception; nested exception is java.lang.ClassCastException: class com.nimbusds.jose.Algorithm cannot be cast to class com.nimbusds.jose.JWSAlgorithm (com.nimbusds.jose.Algorithm and com.nimbusds.jose.JWSAlgorithm are in unnamed module of loader 'app')
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:486) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1334) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1177) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:564) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:524) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:944) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918) ~[spring-context-5.3.6.jar:5.3.6]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-5.3.6.jar:5.3.6]
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:64) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:769) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:337) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1336) ~[spring-boot-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at com.example.demo.DemoApplicationKt.main(DemoApplication.kt:13) ~[main/:na]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.oauth2.jwt.ReactiveJwtDecoder]: Factory method 'jwtDecoderByIssuerUri' threw exception; nested exception is java.lang.ClassCastException: class com.nimbusds.jose.Algorithm cannot be cast to class com.nimbusds.jose.JWSAlgorithm (com.nimbusds.jose.Algorithm and com.nimbusds.jose.JWSAlgorithm are in unnamed module of loader 'app')
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185) ~[spring-beans-5.3.6.jar:5.3.6]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653) ~[spring-beans-5.3.6.jar:5.3.6]
        ... 19 common frames omitted
Caused by: java.lang.ClassCastException: class com.nimbusds.jose.Algorithm cannot be cast to class com.nimbusds.jose.JWSAlgorithm (com.nimbusds.jose.Algorithm and com.nimbusds.jose.JWSAlgorithm are in unnamed module of loader 'app')
        at org.springframework.security.oauth2.jwt.JwtDecoderProviderConfigurationUtils.getSignatureAlgorithms(JwtDecoderProviderConfigurationUtils.java:93) ~[spring-security-oauth2-jose-5.5.0-RC1.jar:5.5.0-RC1]
        at org.springframework.security.oauth2.jwt.ReactiveJwtDecoders.withProviderConfiguration(ReactiveJwtDecoders.java:120) ~[spring-security-oauth2-jose-5.5.0-RC1.jar:5.5.0-RC1]
        at org.springframework.security.oauth2.jwt.ReactiveJwtDecoders.fromIssuerLocation(ReactiveJwtDecoders.java:100) ~[spring-security-oauth2-jose-5.5.0-RC1.jar:5.5.0-RC1]
        at org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerJwkConfiguration$JwtConfiguration.jwtDecoderByIssuerUri(ReactiveOAuth2ResourceServerJwkConfiguration.java:95) ~[spring-boot-autoconfigure-2.5.0-SNAPSHOT.jar:2.5.0-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154) ~[spring-beans-5.3.6.jar:5.3.6]
        ... 20 common frames omitted
```
