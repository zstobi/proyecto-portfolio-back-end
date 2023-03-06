FROM amazoncorretto:19-alpine-jdk

COPY target/final-ap-0.0.1-SNAPSHOT.jar apfinal.jar

ENTRYPOINT ["java","-jar","/apfinal.jar"]
