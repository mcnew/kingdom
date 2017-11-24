FROM openjdk:8-jdk

COPY target/crm-0.0.1-SNAPSHOT.jar /var/lib/misc/crm.jar

EXPOSE 8080

CMD [ "/usr/bin/java", "-jar", "/var/lib/misc/crm.jar", "--spring.profiles.active=awsdemo" ]
