@sendEmail
Feature: User should be able to reply to emails in the chats from inbox

  Background:
    Given User navigates to the Mail.ru login page

  Scenario: Positive user login with valid credentials
    When User inputs following credentials
      | username                | password               |
      | timsearstesting@mail.ru | testcasefromthetestlab |
    Then Validate the user has logged in


  Scenario: Send email to the chars in inbox
    Given Available chats in the inbox
    When User clicks on any of them
    Then User should be able to reply below message inside the modal window
      | message                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris turpis metus, vulputate nec elementum nec, maximus vitae quam. Morbi varius dictum massa, nec aliquam arcu maximus sit amet. Duis eleifend ut nisi nec dapibus. Nam pretium leo id iaculis sollicitudin. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla volutpat nibh nec enim ultricies, ut consequat tellus ullamcorper. Donec at hendrerit sapien. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi ac condimentum sapien. Quisque placerat tellus diam, eget feugiat purus sodales a. |