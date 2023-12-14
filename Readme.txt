
# ZOOtopia - Zoo Management Application

Welcome to ZOOtopia, a zoo management application developed with Java, designed to provide a user-friendly command-line interface for zoo visitors and administrators. ZOOtopia allows visitors to explore and experience the wonders of the animal kingdom while providing administrators with the tools to manage attractions, animals, discounts, special deals, and statistics effectively.

## Table of Contents

- Application Flow
- Features
- Class Structure
-Assumptions

## Application Flow

ZOOtopia has a clear flow for both visitors and administrators:

### For Admins:
1. Admins log in with a predefined username and password.
2. They can then manage attractions, animals, events, discounts, special deals, and view visitor statistics and feedback.

### For Visitors:
1. Visitors can choose to register or log in.
2. After logging in, they can explore the zoo, buy memberships, purchase tickets, view discounts, apply discounts, visit animals and attractions, and leave feedback.

## Features

ZOOtopia features a range of functionalities, including:

- User-friendly command-line interface.
- User authentication for admins and visitors.
- Admins can manage attractions, animals, events, discounts, special deals, and view statistics.
- Visitors can register, log in, explore the zoo, purchase memberships and tickets, apply discounts, visit animals and attractions, and leave feedback.

## Class Structure

ZOOtopia is structured with several key classes and interfaces:

- `Admin` and `Visitor` classes implement user authentication.
- `Attraction`, `Animal`, and `SpecialDeal` classes represent attractions, animals, and special deals.
- `Discount` and `Membership` classes handle discounts and memberships.
- `AdminPanel` and `VisitorMenu` classes provide user interfaces for admins and visitors.
- `Main` class serves as the main application entry point.

##Assumptions 

User Inputs: Assumed that users will provide valid inputs during registration, login, and interaction with the application.

Static Admin Login: Assumed that there's a predefined admin account with the username "admin" and password "admin123" for simplicity.

Visitor Experience Levels: Assumed that visitors can choose between "Basic" and "Premium" membership levels, but the exact perks of these levels are not specified in the requirements.

Discount Eligibility: Assumed that discounts are based on visitor age categories ("minor" and "senior citizen"), but exact age criteria may vary in practice.

Visitor Discounts: Assumed that minor visitors receive a 10% discount, and senior citizens receive a 20% discount, without specifying any additional discount categories.

Ticket Price: Assumed that each attraction has a fixed price for basic members, without accounting for variations in attraction prices.

Special Deals: Assumed the existence of special deals based on the number of attractions visited, with predefined discount percentages, but these deals may vary in practice.

Feedback Length: Assumed a maximum feedback length of 200 characters, but this constraint may be adjusted in real-world scenarios.

Attractions and Animals: Assumed that at least two types of animals exist for each of the three categories (mammals, amphibians, and reptiles), but didn't specify the full list of animals or attractions.

Attraction Schedule: Assumed that events can be scheduled, but the specific event schedule format and rules are not provided.

Ticket One-Time Usage: Assumed that tickets are one-time usage, but didn't specify how ticket validation is managed.

Data Storage: Assumed that data is stored in-memory during program execution and not saved persistently.

User Experience: Assumed that the user interface is text-based and command-line, without graphical elements.
--------------------------------------------------------------

HOME_FOLDER = src

All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.

0) Download the src code folder from Classroom and unzip.
1) mvn clean 
2) mvn compile
3) mvn package
4) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args>
5) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args> 
6) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args> 

--------------------------------------------------------------
