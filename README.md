# 실행방법

```
 mvn spring-boot:run
```

# 테스트

```
1004  http localhost:8080/courses title="MSSQL 관리자 "
 1005  http localhost:8080/clazzes course="http://localhost:8080/courses/1"
 1006  http "http://localhost:8080/clazzes/2"
 1007  http PATCH "http://localhost:8080/clazzes/2" states="OPEN"
 1008  http PATCH "http://localhost:8080/clazzes/2" instructor="???"
 1009  http localhost:8080/instructors firstName="진영" lastName="장"
 1010  http PATCH "http://localhost:8080/clazzes/2" instructor="http://localhost:8080/instructors/3"
 1011  http localhost:8080/clazzes course="http://localhost:8080/courses/1" states="CLOSED"
 1012  http PATCH "http://localhost:8080/clazzes/4" instructor="http://localhost:8080/instructors/3"
 1013  http "http://localhost:8080/clazzes/4/instructor"
 1014  http localhost:8080/clazzDays clazz="http://localhost:8080/clazzes/4" date = "2018-12-1"
 1015  http localhost:8080/clazzDays clazz="http://localhost:8080/clazzes/4" date="2018-12-1"
 1016  http localhost:8080/clazzDays clazz="http://localhost:8080/clazzes/2" date="2018-12-1"
 1017  http PATCH "http://localhost:8080/clazzes/4" instructor="http://localhost:8080/instructors/3"

```

# HTTPie 가 없는 경우

- 맥

> brew install httpie

- 설치 방법: https://github.com/TheOpenCloudEngine/uEngine-cloud/wiki/Httpie-%EC%84%A4%EC%B9%98
