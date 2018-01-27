# 실행방법

```
 mvn spring-boot:run
```

# 테스트

```
http localhost:8080/courses title="aaa" duration=5 maxEnrollment=5 minEnrollment=1

http localhost:8080/clazzes course="http://localhost:8080/courses/1"

http "http://localhost:8080/courses/1/clazzes"
```
