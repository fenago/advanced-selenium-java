# Use the latest image from UBUNTU installed in the machine
FROM ubuntu:latest

# Update ubuntu system
RUN apt-get update

# Install java version on ubuntu-selenium image
RUN apt-get install -y default-jdk
RUN apt-get install -y default-jre

# Install maven on ubuntu-selenium image
RUN apt-get install -y maven

# Install git on ubuntu-selenium image
RUN apt-get install -y git


WORKDIR /TestWebdriver
COPY TestWebdriver /TestWebdriver

# Note: You can also run following command if source is present in github public repo
# RUN git clone https://github.com/username/repo-name

# Run the maven command to execute all the tests
RUN mvn clean install test

ENTRYPOINT ["/bin/bash"]