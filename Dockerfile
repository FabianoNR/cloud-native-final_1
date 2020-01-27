FROM jetty:9.3-jre8

LABEL maintainer="Fabiano Nogueira Rapkiewicz"

ADD build/libs/tema-06-1.0.war /var/lib/jetty/webapps/root.war
