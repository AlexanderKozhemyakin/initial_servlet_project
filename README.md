# initial_servlet_project 
Goal: For learning purpose
Short Descripion: Simple jakarta ee web app. 
With use of JSP made frames to check get/post parameters handling, fileupload, register form...

usefull commands:

mvn clean package tomcat7:redeploy; /opt/tomcat/bin/startup.sh

/opt/tomcat/bin/shutdown.sh

//manually you can deploy using manager and to run firefox with url of manager yo can use:

firefox --new-tab http://localhost:8080/manager

//After deployment open app n firefox:

firefox --new-tab http://localhost:8080/shopservletapp

List Currently Deployed Applications:
firefox --new-tab http://localhost:8080/manager/text/list

List OS and JVM Properties
firefox --new-tab http://localhost:8080/manager/text/serverinfo

Start an Existing Application
http://localhost:8080/manager/text/start?path=/examples

Thread Dump
http://localhost:8080/manager/text/threaddump

VM Info
http://localhost:8080/manager/text/vminfo

Server Status
http://localhost:8080/manager/status/all
http://localhost:8080/manager/status/all?XML=true

/opt/tomcat/bin/shutdown.sh

Current status of developement:
![Снимок экрана от 2022-08-24 15-50-06](https://user-images.githubusercontent.com/110842572/186432984-9abffa6f-8af2-4473-8878-4028f7b06599.png)
