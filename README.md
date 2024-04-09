# StreamMediaApp
 come settare application.yml    :
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/{NOMESCHEMA}
    username: {USERNAME}
    password: {PASSWORD}
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
  sql:
    init:
      mode: always
  properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5Dialect
    


server:
  port: 8080
