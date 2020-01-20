FROM jetty:9.3-jre8

LABEL maintainer="Fabiano Nogueira Rapkiewicz"

ADD build/libs/tema-06.war /var/lib/jetty/webapps/root.war
