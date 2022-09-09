
# Project Title

Jakarta EE Web App

## Prerequisites
tomcat 10 and Java 11 installed

## Installation

1. Download/clone project/
2. Set in pom.xml username and password for tomcat user for deployment
3. Build project, deploy generated war:
```bash
mvn clean package tomcat7:redeploy; /opt/tomcat/bin/startup.sh
```
4. After deployment open app in browser:

firefox --new-tab http://localhost:8080/shopservletapp

## Demo screenshot
![Снимок экрана от 2022-08-24 15-50-06](https://user-images.githubusercontent.com/110842572/186432984-9abffa6f-8af2-4473-8878-4028f7b06599.png)
## Support

No support ;-) 
App under construction and is developed for learning purpose/ practise