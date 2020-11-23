@tag
Feature: Verify whether application allows admin to create a category & course on the category

Scenario: Validate if the admin user is able to create a category
Given user is logged onto the Elearning website as an admin user with valid username is "<username>" & password is "<password>" entered
When user Clicks on Courses Categories link
And user Clicks on Add Category icon
And user Enters valid credentials in "<Category Code>" and "<Category name>" textbox
And user Selects Yes radio button and Clicks on Add Category button
And user Clicks on Administration Link
And user Clicks on Create a Course link
And user Enters valid credential in "<Title>" "<Code>" "<Category>" textbox
And user Selects "<Teachers>" "<Language>" list box
Then user Clicks on Create a course button.
 
    Examples: 
      | username | password  | Category Code | Category name    | Title   | Code | Teachers | Category         			| Language | 
      | admin    | admin@123 | BL1            | Blended Learning | Testing | Tes  | Manzoor  | Blended Learning (BL) | English  | 