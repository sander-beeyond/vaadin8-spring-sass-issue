# vaadin8-spring-sass-issue

An example Vaadin 8.5.2 project which contains an issue with the at runtime Sass compiler. 
The project uses Spring 4.3.9, spring-boot 1.4.7 and Spring-boot-starter 3.0.0.
Because Spring is used and the application is packaged as a jar the webapp folder can no longer be used.
The contents of the VAADIN folder have been moved to the resources directory but this causes an issue with the Sass runtime compiler. The at runtime compiler no longer functions and for any new theme changes to show up the application has to be restarted or a new mvn clean install has to be executed.
When the webapp folder is put back in place the runtime compiler functions as intended when refreshing a page. 
This is not an issue when deploying the application since the style.css is correctly generated in the resources directory during a Maven install by the vaadin-maven-plugin.

On the fly compilation does not work when:
* /main/resources/VAADIN/themes/apptheme/styles.css is present
* The webapp folder is deleted and its content are moved to /main/resources/VAADIN
* /main/resources/VAADIN/themes/apptheme/apptheme.scss is changed

When theme adjustments inside the resources directory show up:
* After mvn clean install which generates styles.css and restaring the application
* After mvn clean install which generates styles.css and refreshing the page

On the fly compilation works when:
1. mvn clean install is executed at least once
2. /main/resources/themes/apptheme/styles.css is deleted
4. /main/webapp/VAADIN/themes/apptheme is added with the same content as in the resources
5. /main/webapp/ is asigned as a web resource directory in the project module settings
6. mvn clean is executed
7. The application is (re)started
8. /main/webapp/VAADIN/themes/apptheme/apptheme.scss is changed
9. Refresh page

Side notes:
* The apptheme is found, updated and compiled 2 times during a maven install when present in both /main/resources/VAADIN and /main/webapp/VAADIN
