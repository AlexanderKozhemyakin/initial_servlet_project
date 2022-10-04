
# Project Title

Jakarta EE Web App

## Prerequisites
tomcat 10 and Java 11 installed

## Installation

1. Download/clone project/
2. Set in pom.xml username and password for tomcat user for deployment
3. Build project, deploy generated war:
```bash
/opt/tomcat/bin/startup.sh; /opt/tomcat/bin/shutdown.sh; /opt/tomcat/bin/startup.sh
java -jar /h2/bin/h2-2.1.214.jar
mvn clean package tomcat7:redeploy
```
4. After deployment open app in browser:

firefox --new-tab http://localhost:8080/shopservletapp

## Demo
![preview](https://user-images.githubusercontent.com/110842572/193664356-9f586136-110a-442f-bb85-abac5a724b11.gif)

## Support
App is under construction and is developed for learning purpose/ practise
