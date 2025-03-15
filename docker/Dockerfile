# 1. OpenJDK 21 이미지 사용
FROM openjdk:21-jdk

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. JAR 파일 복사
COPY build/libs/*.jar app.jar

# 4. 실행 포트 설정
EXPOSE 8080

# 5. 애플리케이션 실행 (MySQL이 실행될 때까지 대기 가능)
ENTRYPOINT ["java", "-jar", "app.jar"]