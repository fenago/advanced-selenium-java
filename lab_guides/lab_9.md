Containerizing your automation platform (Docker + Selenium)
===========================================================


Pre-requisites for executing the automation tests 

1. The project should be a maven project with a properly implemented pom.xml
with all the project dependencies in it**. **

2. The project should have a TestNG.xml file which would have all the test classes that needs to be executed.



Step-1: To begin with we would want to have an image where we can ship
our changes and containerize it. So, just type in ***docker run
ubuntu. ***Once you do that it will try searching your image locally. If
it does not get an image it will download an image from the "*Docker
registry*". Check the image to refer.

![ubuntu\_install](./images/ubuntu_install.gif)

Once this is done you can check the images and the containers locally
present in your host machine.

Step-2: Try running "***docker ps -a***" to get the list of all
containers existing in your machine and running "***docker images***"
will give you the list of all the images in the system. Check the image
to refer

![check\_img\_conts](./images/check_img_conts.gif)

Step-3: Now what er need to do is configure a template which is
basically called a "**Dockerfile**". The Docker client uses this
template to interact with the daemon process. Create a file in your
project root folder named as "**Dockerfile**".

In this `Dockerfile` we are going to write down few lines of code to
create a container from the existing image which would preferably
consists steps to install required dependencies and update the existing
system.

Here is the code snippet that you would be needing to run this entire
automation suite. In my project I have the `Dockerfile` inside the
`Docker` directory.

```
# Use the latest image from UBUNTU installed in the machine
FROM ubuntu:latest

MAINTAINER corefinder@docker.com

# Update ubuntu system
RUN apt-get update

# Install java version on ubuntu-selenium image
RUN apt-get install -y default-jdk
RUN apt-get install -y default-jre

# Install phantomjs
RUN apt-get install -y phantomjs

# Install maven on ubuntu-selenium image
RUN apt-get install -y maven

# Install git on ubuntu-selenium image
RUN apt-get install -y git

# Get the repository onto the local system
RUN git clone https://:x-oauth-basic@github.com/SoumyajitBasu1988/.git

# Run the maven command to execute all the tests
WORKDIR "/DockerSelenium"
RUN mvn clean install test

ENTRYPOINT ["/bin/bash"]
```

So, this `dockerfile` would basically get the dependencies installed
within the container which would include 1. `git` 2. `maven` 3.
`Java version 8`. After this it will take a clone of the required
repository, navigate to the working directory and run the
`mvn clean test` which would execute your required test automation
within the container. Check it out in the image below. I have used OAUTH
to get a clone of the repository. You might set the ssh key in the
container as well.

![Run\_automation\_container](./images/run_automation_container2.gif)

So, in the image above what I did was docker build by using the command
`docker build -t .`, -t represents tag name and . represents that the
`Dockerfile` is in the current working directory. So, once you build has
been execute you can even access the container. Just type in
`docker run -it`

``. In the image below I just executed the command and it logged me into
the container where I could directly run the tests.

![access\_container](./images/access_container.gif)

So, I would come to the conclusion answering your question "Why would we
need Docker?" I hope I was able to help you sort out the immense
importance of containerization of your automation platform. To gist it
in terms of deploying your automation platform.

1.  It becomes far more easy if you have to showcase your framework to
    the client side all you need to do is push your image into the
    docker hub and they can take a clone from it. It’s pretty simple to
    push your latest container to `docker hub`. It is very similar to
     using git All you need is just type in the following commands

![push\_image](./images/push_image.gif)

​2. As I said earlier as well portability becomes much easier. If you
are running your code on the server you don’t have to worry about
setting the entire automation platform. You can always build the
container from the `Dockerfile`.

​3. Reducing dependency of the automation platform on the host machine.

That’s it folks for now. I hope I was able to deliver something that can
be utilized when automating your application and by this you can also
provide a newer direction to deploying your automation codebase.

To understand the working you can clone my repository from
[GitHub](https://github.com/Corefinder89/DockerSelenium)
