Feature: ContactUs Form
  User should be able to successfully submits a message via the contactUs Form

  Background:
    Given user access the webdriveruniversity.com

  Scenario Outline: Submit message via the contactUs form
    When clicks on the ContactUs Form link
    And enters a valid firstname
    And enters a valid lastname
    And enters an email address
    And provide additional comments as <commentsText> in the comments box
    And submits the form
    Then the form should be successfully submitted displaying <outputMsg>

    Examples:
      | commentsText                          | outputMsg                   |
      | The information needs to be submitted | Thank You for your Message! |
