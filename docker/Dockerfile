# 基础镜像
FROM openjdk:8-jdk-alpine

# 作者信息
MAINTAINER "kao.chun kao@gmail.com"

# 添加一个存儲空間
VOLUME /tmp

# 暴露8080端口
EXPOSE 8080

# 添加變量，如果使用dockerfile-maven-plugin，则會自動替换这里的变量内容
ARG JAR_FILE=target/spring-boot-demo-docker.jar

# 往容器中添加jar包
ADD ${JAR_FILE} app.jar

# 启动镜像自动运行程序
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/app.jar"]