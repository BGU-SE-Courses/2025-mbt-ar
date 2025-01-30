# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called PrestaShop (https://demo.prestashop.com/#/en/front).

Prestashop is a e-commerce platform for sellers, consumers.
## Installation
Install provengo, chroemedriver and selenium in your pc. 
Install prestashop through the directory. full explanations are in there.
Go to provengo directory and act as in readme.md overthere, until getting the results you are appreciated.



## What we tested
We tested the PrestaShop module for a clothes shop that allows guests to add comments to product pages. We focused on the following user story:

1. Guest Adds a Comment to a Product

  Preconditions:
  
  The clothes shop has a product page with commenting enabled.
  
  Guests are allowed to post comments.
  
  Expected Outcome:
  
  The guest successfully submits a comment, which appears on the product page.

2. Admin Disables Guest Comments

  Preconditions:
  
  Guest commenting is enabled, and there are existing comments from guests.
  
  The admin has access to the settings to manage commenting permissions.
  
  Expected Outcome:
  
  The admin disables guest commenting.
  
  Guests can no longer add new comments to product pages.



## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

