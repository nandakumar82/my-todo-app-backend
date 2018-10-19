FROM openjdk:8
ADD target/my-todo-app.jar my-todo-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my-todo-app.jar"]