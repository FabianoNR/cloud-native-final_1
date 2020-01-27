#!/bin/bash -e

docker pull jenkins/jenkins:lts
docker run --name jenkins -d -p 8080:8080 jenkins/jenkins:lts

docker pull docker.bintray.io/jfrog/artifactory-oss:latest
docker run --name artifactory -d -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest 