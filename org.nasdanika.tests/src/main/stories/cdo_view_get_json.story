Get on CDOView

Meta:
@category CDOView


Narrative: 

In order to show the CDOView GET JSON functionality
As a user
I want to explore CDOView structure in JSON format

Scenario: GET on CDOView

Given Routing servlet URL http://localhost:8080/router/
When I issue GET on ccview
Then it shall return ["bank"] with application/json content type

Scenario: GET on CDOView with .json extension

Given Routing servlet URL http://localhost:8080/router/
When I issue GET on ccview.json
Then it shall return ["bank"] with application/json content type
