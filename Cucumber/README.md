# Testing PrestaShop using Cucumber
This directory contains the cucumber files for testing the Admin Admin & Customer functionality module of the PrestaShop application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

$$*TODO*: Make sure that the text inside the feature files is informative and self-explanatory. This includes the "Feature: ...", "Scenario: ...", and "Given/When/Then ..." lines. See the "example.feature" file for an example.

## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
