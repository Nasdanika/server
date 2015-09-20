# Nasdanika Application Workspace Wizard

Nasdanika Application Workspace Wizard generates a set of projects which constitute Nasdanika Foundation Server Application.

This [6 minutes video](https://www.youtube.com/watch?v=Gg4CNgqoHR4) demonstrates how to:
* Generate application projects with default settings
* Resolve and set target platform
* Run the application in Eclipse
* Build and test with Maven
* Start the Eclipse product 

## Pre-requisites
* Maven integration for Eclipse (``M2E``) - generation will fail if M2E is not installed. To install go to ``Help > Eclipse Marketplace``.
* Tycho configurator. ``pom.xml`` files will show errors if not installed. To install go to ``Preferences > Maven > Discovery``, click ``Open Catalog``. 

## Generate application workspace

To start the wizard click ``File > New > Other`` or click ``Ctrl-N`` and then select "Nasdanika Application Workspace":

![Wizard selection](wizard-selection.png)

The wizard opens the general information page where you can enter application name, group ID, specify location and select a working set to add newly generated project to:

![General information](general-information.png)

Group ID is used in ``pom.xml`` files and as a base name for projects. Click ``Next`` to navigate to the projects page:

![Projects](projects-page.png)

Projects:
* Model - an empty EMF project
* Application - contains web content, OSGi components, router servlet registration, documentation and application routes.
* Tests and UI driver - [Nasdanika WebTest](https://github.com/Nasdanika/server/wiki/webtest) projects with initial tests to automatically test the Web UI of the generated application.

Uncheck projects which you don't need, modify default suffixes, if needed, and click ``Next``. If application project was selected, then the application page will open:

![Application](application-page.png)

Modify default selections and values if needed:
* Context path - web application context path.
* HTTP Context ID - used by the router and session servlets.
* Router servlet - dispatches requests to routes and repository objects.
* Session servlet - [WebSocket](https://en.wikipedia.org/wiki/WebSocket) servlet used by the CDO JavaScript API (see the bundled documentation)
* Web Content - location and alias.
 
#### OSGi components:
* H2 Repository - generates an H2 repository component.
* Server - CDO server.
* TransactionContextProvider - used by CDO web routes.
* Documentation route - integrated documentation.
* Documentation application route - integrated documentation.
* Session initializer - registers packages with CDO session and creates initial repository content.

Click ``Finish``. After several seconds the wizard will generate workspace projects and Eclipse will build them. There will be errors:

![workspace with errors](workspace-with-errors.png)

Open the target definition file in the target project. Wait until the target is resolved and then click "Set as Target Platform", after workspace re-build errors shall disappear.

![target definition](target-definition.png)

## Start the application from Eclipse

Open the product file in the repository project and click ``Launch an Eclipse Application``. 

![Launch An Eclipse Application](launch-an-eclipse-application.png) 

Once you see ``Indexed X pages`` in the OSGi console open a web browser and navigate to the application route, e.g. ``http://localhost:8080/demo-app/router/demo-app.html``. Then open the documentation application, e.g. ``http://localhost:8080/demo-app/router/doc.html``.

Issue ``shutdown`` command in the OSGi console to stop the application. If the application doesn't terminate after a couple of seconds, issue another command, e.g. ``ss``.

## Build Eclipse Product
Right-click on the ``pom.xml`` file in the aggregator project and select ``Run as > Maven Build``, enter ``clean verify`` to the goals input:

![Maven Build From Eclipse](maven-build-from-eclipse.png)

Click ``Run``. Maven will build projects, execute UI tests, and build the Eclipse product for the application. By default UI tests use [Firefox Web browser](https://www.mozilla.org/en-US/firefox/new/). If Firefox is not available, modify tests code to use a different driver. When build finishes you should see console output similar to the one shown below:

![Maven Build Result](maven-build-result.png)

## Execute Eclipse Product
Refresh the repository product and then open ``target/products/.../x86_64`` (or another folder depending on your OS):

![Built product](built-product.png)

Double-click ``eclipse.exe``. A console window will open. Give the application several seconds to start and open a web browser. Navigate to the application route and documentation route and then shut down the application as described in the "Start application from Eclipse" above.

# Generated workspace projects
![workspace projects](workspace-projects.png)

* Model project - contains ECore/CDO model(s). 
* Aggregator - use this project's pom to build the product.
* Application project - contains OGSi components, session initializer, servlet extensions.
* Feature - feature project.
* Parent - contains parent pom.
* Repository - repository project.
* Target - target definition, used only by Eclipse IDE.
* Tests - JUnit tests. 
* Tests feature - Tests feature.

## UI Driver
* Actors
* Actors impl
* Pages
* Pages impl
 
See also: 
* [Eclipse Tycho for building Eclipse Plug-ins and RCP applications](http://www.vogella.com/tutorials/EclipseTycho/article.html).
* [WebTest](https://github.com/Nasdanika/server/wiki/webtest). 

# Summary
After completing the steps described above you will have a functional Nasdanika Foundation Server (OSGi/CDO) web application:
* Minimal initial functionality
* Hosts its own documentation
* Runnable/debuggable from Eclipse
* Has automated UI tests
* Buildable/testable with Maven/Tycho
* Build produces a deployable binary

# Next steps
* Check-in code to a version control system
* Set up an automated build job
* Create a model in the model project
* Document the model - see the integrated help for details
* Publish the model documentation - it will serve as the basis of the application's [Ubiquitous Language](http://martinfowler.com/bliki/UbiquitousLanguage.html).
* Add web functionality by creating route operations
* Add more bundles to the project as required


 


 






       








