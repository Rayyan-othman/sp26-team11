## Title
> AutoBid 

## Team Members
> Team Member #1 Rayyan Othman
> Team Member #2 Gopal Vulli


## Description 
Our project is a system/service that allows the customer to book mobie on site general mechanic and detailing services right to their fornt door with ease and convenience customer can veiw a list of provers and ther serbice the offer and book and leave reveiws with specialists that meet their need and providers can post themseves and their qualifications and receive reveiws on their work and get feedback and jobs for themselves through this system app. This app will solve the problem of being to busy to get tho these sort of service locations and the motivation behind this to make general repairs and cleaning and detailing for convenient automated and accesable for people.

## App Functions

1.  SysAdmin Rayyan othman (the user with the admin role ):
    1. Manage user access - will allow the system admin user to log in and make changes and veiw the app as an administrator .
    2. Moderate services - can remove add change or adjust the app ,services or users if needed.
    3. Moderate reviews - allows for removing commenting and moderation of all reveiw left by customers and providers.
    4. View usage statistics - System admine user can collect veiw and save data statistivs collected from the customer and provider use cases.

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







