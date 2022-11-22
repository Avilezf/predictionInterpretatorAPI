FROM ubuntu:latest
# install packages
RUN apt-get update && \
    apt-get install -y curl \
    wget \
    openjdk-8-jdk \
    python3 \
    python3-pip

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME
ENV LD_LIBRARY_PATH /usr/local/lib/python3.10/dist-packages/jep
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} javaPythonInterpreter-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "javaPythonInterpreter-1.0.jar"]

COPY requirements.txt requirements.txt
COPY src/main/resources/python python
RUN pip3 install -r requirements.txt