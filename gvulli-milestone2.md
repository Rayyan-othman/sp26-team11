## 1. Overview

- **Vision:**
AutoBid is a web app that connects customers with mobile on-site mechanics and detailing providers. Customers can book services at their location, leave reviews, and manage their profiles. Providers can create service listings, manage availability, and respond to reviews. Administrators oversee system moderation and user access.



## 2.2 Provider Stories

- **US-PROV-001 — Create provider profile**  
*Story:* As a provider, I want to create and update my profile with qualifications and certifications so that customers can trust my services.  

*Acceptance:*

Scenario: Create provider profile
    Given I am registered as a provider
    When I enter my qualifications and save my profile
    Then my provider profile is saved
    And it becomes visible to customers

- **US-PROV-002 — Create service listing**  
*Story:* As a provider, I want to create mechanic or detailing services with pricing and descriptions so that customers can book my services.

*Acceptance:*

Scenario: Publish service listing
    Given my provider profile is active
    When I enter required service details and confirm
    Then the service is created in "Published" state
    And it appears in customer search results

- **US-PROV-003 — Update availability**  
*Story:* As a provider, I want to update my availability schedule so that customers can only book during my available times.

*Acceptance:*

Scenario: Update availability schedule
    Given I have an active provider account
    When I update my available time slots
    Then customers see the updated availability
    And unavailable time slots cannot be booked

- **US-PROV-004 — View booking statisticsy**  
*Story:* As a provider, I want to view booking history and ratings so that I can track my performance.

*Acceptance:*

Scenario: View provider statistics
    Given I am logged in as a provider
    When I open the statistics dashboard
    Then I see my booking history
    And I see my average rating

- **US-PROV-005 — Reply to reviews**  
*Story:* As a provider, I want to respond to customer reviews so that I can address feedback professionally.

*Acceptance:*

Scenario: Reply to customer review
    Given a customer has left a review on my service
    When I submit a reply
    Then my response appears below the review