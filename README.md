# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called PrestaShop (https://prestashop.com/).

Prestashop is a e-commerce platform for sellers, consumers.
## Installation
Install provengo, chroemedriver and selenium in your pc. 
Install prestashop through the directory. full explanations are in there.
Go to provengo directory and act as in readme.md overthere, until getting the results you are appreciated.



## What we tested
For example, in the case of the Moodle example, you can write something like this:
We tested the review/commeents module, that allows guests to leave a comment/review in a product, and lets the admin control this option through admin panel.
We chose to test the following stories:
1.*User story:* guest leave a review in a product
pre-conditions: there are products in admin shop.
expected outcome: review has been saved, and shown in product page. if can't add it, test fails.
2.*User story:* Admin turn off:.
pre-conditions: there are products in admin shop, admin user is check@check.check ,password: 12345678
expected outcome: Save success, A guest can not leave a comment.



## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

