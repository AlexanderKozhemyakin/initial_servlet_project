
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
java -jar /home/alex/java_projects/h2/h2-2022-06-13/h2/bin/h2-2.1.214.jar
java -jar /root/Загрузки/h2-2022-06-13/h2/bin/h2-2.1.214.jar
mvn clean package tomcat7:redeploy


sessionId:null
url:
generateRandomBase64TokenSessionId(256):jYVimlznPsYW-cpEt5AV-v-Nj-dFGyjwLacYt8eR8zL-x08xsPSwPNDr09tjkqL7pdnOL5U-7I5PrD9n85qfxmpxlnzW-W4hPbgqWLXBV_RcrE7Ydib4jnfU95LgcV6dwr3J3al__T8kcQm3rmfxAp5ejSBe7vBwlvIUAwHaKAlVEjht8_POfd6DHcvJd8yttoXBNA15jCcyRZkNE-bfeWS9asovE6nNmL_1TzfwlKFYI9s28mYMvzCvgpuwti-rdGqFkg5jOZRzg5_MWznOczsjRjVdQ6PO98S-KgPfLwdOB0-KqFYNwgGO08Pv_OPQD8qMBOh6GPahGwQnBGqJQA
httpServletRequest.getHeader("Referer"):null
httpServletRequest.getRequestURI():/shopservletapp/
httpServletRequest.getQueryString():null
httpServletRequest.getServletPath():/index.jsp
httpServletRequest.getAuthType():null
httpServletRequest.getParameterNames():java.util.Collections$3@196a2c53
httpServletRequest.getContextPath():/shopservletapp
httpServletRequest.getPathInfo():null
httpServletRequest.getRequestURL():http://localhost:8080/shopservletapp/
httpServletRequest.getRequestURL().toString():http://localhost:8080/shopservletapp/
httpServletRequest.getPathTranslated():null
httpServletRequest.getRemoteUser():null
httpServletRequest.getCharacterEncoding():UTF-8
httpServletRequest.getContentType():null
httpServletRequest.getLocalAddr():127.0.0.1
httpServletRequest.getRequestedSessionId():null
httpServletRequest.getRemoteAddr():127.0.0.1
httpServletRequest.getContentLength():-1

```
4. After deployment open app in browser:

firefox --new-tab http://localhost:8080/shopservletapp

## Demo screenshot
![Снимок экрана от 2022-08-24 15-50-06](https://user-images.githubusercontent.com/110842572/186432984-9abffa6f-8af2-4473-8878-4028f7b06599.png)
## Support

No support ;-) 
App under construction and is developed for learning purpose/ practise