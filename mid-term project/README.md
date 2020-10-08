# Software Design Pattern: mid-term assignment 

The objective of this exercise is to utilize some of the design patterns you learnt so far and to prepare you for further discussion that we will have in class. 
As such, you will not be graded on the specifics of your design; rather, you will receive full credit if your system supports all the required classes, operations and the code follows OOP principles and design patterns.

# Deadline

Week 8 - 10/12

## Problem description
You are hired to design an invitation RSVP system for different types of events. Since you are the expert on software architecture design, you want to design a generic system.
Apply the design patterns you learnt in class as you see fitting.

### Features
This is the set of features your system must support:
* Accept an event with all the details: description, venue, scheduled time, number of guests and social network event link.
* Host information: name and address of the organizer.
* Build invitation cards, based on the event type, there is a theme tied to each type:
    * Birthday
    * Wedding
    * Graduation Party
    * Get Together
* Send RSVP requests to guests
* Upon receiving the RSVP response, notify the organizer of the event.

## Output
Push your changes under a branch with <your name-midterm> to git repo, for example:
`git push smostafa-midterm origin develop` 
Your folder should include a README with the following sections defined
* Classes
* Class Description
* Operation supported by each class

### Example
Class: Event
Class Details: represents the event information which includes description, venue, organizer name and date.
Operation: find the organizer's name for an event.

### Required Operations
Your design should be able to answer the following questions:
* How to create a themed invitation to guests based on the event type?
* How many Birthday/Wedding/Graduation Party/Get Together events the system has?
* How many invitations sent for an event?
* How many accepted/rejected invitation responses received?
* How to notify a host when a guest responds?

## Grading Criteria 
There is no right or wrong answer here, but your system should not violate OOP principles and should have a clear readable structure.

### Rules
* No repeated code
* Each class should have a single responsibility role
* Code must compile successfully 

