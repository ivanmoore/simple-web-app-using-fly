FROM gradle:8.5-jdk21-jammy
RUN mkdir /code
COPY . /code/
WORKDIR /code
RUN gradle clean build fatJar
EXPOSE 8123
CMD java -jar build/libs/simple-web-app-using-fly-fat-jar-1.0.0.jar
