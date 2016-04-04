# Template for spring based web-apps

#### USAGE (skip if you are ok with name 'sample-spring-app')
* Clone the project
* Change the groupId and artifactId to the name of your project in pom.xml
* Change name in .project file to the name of your project
* Rename the src/main/webapp/WEB-INF/sample-spring-app-servlet.xml to <your project name>-servlet.xml
* Change all occurences of <display-name> and <servlet-name> in src/main/webapp/WEB-INF/web.xml to name of your project
* In case you add more packages, add them to <context:component-scan> in sample-spring-app-servlet.xml to enable annotation scan 

#### CAUTION
This sample comes with an embedded web launcher that makes it self contained and avoid any dependency on external web container. Please don't change anything in org.bytegeeks.embedded.MainLauncher (unless you know what you are doing)

#### TEST
1. run mvn clean package appassembler:assemble
2. Run shell/bat script in target/appassembler/bin/<app-name>
3. Open any browser and point to http://localhost:8080/test. If you see "All OK", then you are all set
