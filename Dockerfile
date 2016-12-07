FROM java:8

MAINTAINER Ruslan Popenko "ruslanpopenko@ukr.net"

RUN  \
  export DEBIAN_FRONTEND=noninteractive && \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade && \
  apt-get install -y maven

VOLUME /vol/development

# create working directory
RUN mkdir -p /vol/development

ADD pom.xml /vol/development/

ADD src/ /vol/development/src/

ADD .git/ /vol/development/.git/

WORKDIR /vol/development/

CMD ["mvn", "spring-boot:run"]