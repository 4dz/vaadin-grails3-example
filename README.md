# Vaadin on Grails 3 Example
This example application is again based upon the examples within the Vaadin manual 
"[Book of Vaadin](https://vaadin.com/book/)", but this project uses Grails 3 and an 
[alternative Vaadin plugin](https://github.com/vaadin-for-grails/grails3-vaadin7-plugin).

If you have SDKMAN (the latest version of GVM) installed you can switch between versions of Grails with, for example,

    sdk default grails 3.0.9
    sdk default groovy 2.4.5

## Getting Started with Vaadin for Grails 3
This project was created within IntelliJ Idea.  Some instructions are available 
[on github](https://github.com/vaadin-for-grails/grails3-vaadin7-plugin) and within the [documentation](https://github.com/vaadin-for-grails/organization/wiki) 
The following instructions may be useful if starting a new project.

1. Install Grails 3 and Groovy 2.4.5
2. Create a Grails 3 project within the IDE
3. Add the repo vaadin/grails3 plugin repo to your build.gradle file.  
   IMPORTANT: this should go in the `repositories { ... }` section and NOT the `buildscript { repositoriies { ...} }` 
   section!

    ```
    maven { url "https://dl.bintray.com/vaadin-for-grails/plugins" }
    ```

4. Add the plugin dependency to your build.gradle file..

    ```
    compile 'org.grails.plugins:vaadin7:3.+'
    ```

5. Finally execute the grails command `grails vaadin-quickstart com.yourcompany` and run your app. 
   If you get an error message `Error Could not resolve all dependencies for configuration ':testRuntime'` then you 
   have probably added the maven url to the wrong 'repositories { ... }' section in build.gradle.

6. Run the gradle build

7. If you want to use conf/vaadin.yml to list out the views and navigation then your root url must include a
   hash-bang #! or else it will fail 'Trying to navigate to an unknown state'. (I think this is a bug in the plugin).
   For example,
   ```
   mappings:
   
   - uri: '/vaadin#!'
     theme: 'grails'
     pageTitle: 'Vaadin for Grails 3'
     view: 'app.views.StartView'
    ```
    
    You can implement your own Vaadin UI, as per the Grails 2 plugin example if you prefer.

## Running this project
Vaadin for Grails 3 runs Vaadin alongside Grails.  If you access the root of the application you will reach Grails 
content; if you access paths which are mapped to Vaadin, you will get Vaadin content.

So when this project runs if you go to http://localhost:8080 you will get a Grails/GSP page; the vaadin aspect of the
application is at http://localhost:8080/vaadin

## Navigator
If using the conf/vaadin.yml mappings, there is no need to use the Navigator directly - unlike the Grails 2 example.

## References
* [Vaadin For Grails Documentation](https://github.com/vaadin-for-grails/organization/wiki)
* [Vaadin For Grails 3 plugin](https://github.com/vaadin-for-grails/grails3-vaadin7-plugin)
