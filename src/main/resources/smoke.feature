Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main components visible
    Given User opens '<homePage>' page
    And User checks main content visibility
    And User checks footer visibility
    And User checks shopping cart visibility
    When User checks my account icon visibility
    And User checks input field visibility
    And User checks search button visibility
    And User checks main container of category visibility
    Then User checks asos logo visibility

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check product title include keyword search
    Given User opens '<homePage>' page
    And User checks input field visibility
    And User checks search button visibility
    When User enters search '<keyword>'
    And User clicks search button
    And User checks first product visibility
    Then User checks the title include '<keyword>'

    Examples:
      | homePage                  | keyword         |
      | https://www.asos.com/men/ | New Balance     |

  Scenario Outline: User need a help with returning
    Given User opens '<homePage>' page
    And User checks help and contact visibility
    And User clicks help and contact button
    When User checks search field visibility
    And User enter question "<question>"
    And User checks search lists visibility
    Then User checks help page titles include '<question>'

    Examples:
      | homePage                  | question    |
      | https://www.asos.com/men/ | return      |

  Scenario Outline: User add grey hoodie to wish list
    Given User opens '<homePage>' page
    And User checks input field visibility
    And User checks search button visibility
    When User enters search '<keyword>'
    And User clicks search button
    And User check hoodie
    And User checks filters visibility
    And User enter grey colour in filters
    And User checks grey hoodie visibility
    And User click on add to wish list grey hoodie
    And  User clicks on wish list
    Then User checks product in wish list visibility

    Examples:
      | homePage                  | keyword         |
      | https://www.asos.com/men/ | hilfiger hoodie |

  Scenario Outline: User buy shoes without size
    Given User opens '<homePage>' page
    And User checks input field visibility
    And User checks search button visibility
    And User enters search '<keyword>'
    And User clicks search button
    And User checks first product visibility
    When User clicks on first product
    And User checks image product visibility
    And User clicks add to bag
    Then User checks error massage

    Examples:
      | homePage                  | keyword      |
      | https://www.asos.com/men/ | New Balance  |

  Scenario Outline: User enter incorrect Email in sign in form
    Given User opens '<homePage>' page
    When User checks my account icon visibility
    And User clicks my account
    And User checks form visibility
    And User enters '<email>'
    And User enters password '<password>'
    And User clicks sign in
    Then User checks error message

    Examples:
      |  homePage                  | email          | password|
      |  https://www.asos.com/men/ | oleksanfasfMail|asdasdasd|

  Scenario Outline:User add to bag socks with category menu
    Given User opens '<homePage>' page
    And User checks main container of category visibility
    And User clicks socks in clothing category
    And User checks socks product visibility
    When User checks filters visibility
    And User clicks no size socks
    And User clicks socks product icon
    And User clicks add to bag
    Then User checks my bag dropdown

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: User removes product from their bag
    Given User opens '<homePage>' page
    And User checks main container of category visibility
    And User clicks socks in clothing category
    And User checks socks product visibility
    When User checks filters visibility
    And User clicks no size socks
    And User clicks socks product icon
    And User clicks add to bag
    And User clicks view bag
    And User checks product in my bag visibility
    And User click remove product button
    Then User checks that my bag empty

    Examples:
      |homePage                 |
      |https://www.asos.com/men/|

  Scenario Outline: User checks product titles include brand name
    Given User opens '<homePage>' page
    And User checks main content visibility
    And User checks main container of category visibility
    When User click in adidas in shoes category
    And User checks adidas header visibility
    Then User checks products descriptions include adidas

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: User check error message in shippable country
    Given User opens '<homePage>' page
    And User checks input field visibility
    And User checks search button visibility
    And User enters search '<keyword>'
    And User clicks search button
    And User checks first product visibility
    When User clicks on first product
    And User checks image product visibility
    And User clicks shipping restrictions
    And User enters '<country>' in search field
    Then User checks error search country massage

  Examples:
    | homePage                  | keyword         | country    |
    | https://www.asos.com/men/ | New Balance     | asfasfas   |