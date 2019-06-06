This is a java web application to manage the templates maintained by our team

Prerequisites to run the project

Java, maven, JSON plugin in browser for better viewing(optional)

Steps to run the project

    1. Checkout the git repositoty and import the project into intellij or eclipse as maven project

    2. Now cd to the root of the project and run the below command mvn clean install

    3. Once the build is complete, run the java application using

        ./mvnw spring-boot:run

        Make sure that its running successfully. Now the backend is ready to serve the contents to the frontend

    4. Now navigate to http://localhost:8080 in the browser

    5. To list the endpoints available tin the application, navigate to

        http://localhost:8080/swagger-ui.html

    6. All the endpoints related to template management are under

        http://localhost:8080/api/v1/templates/

    7. All the endpoints related to platform details are under

        http://localhost:8080/api/v1/platforms

    8. To start the frontend project navigate to frontend/templates-ui and run the below command

        ng serve

    9. Now navigate to the following link in your browser

        http://localhost:4200

Contact CloudStack team if you need more information on this application
