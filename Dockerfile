FROM openjdk:21
MAINTAINER hk
COPY target/cart-0.0.1-SNAPSHOT.jar cart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/cart-0.0.1-SNAPSHOT.jar"]