How to Run:
javac rsvp.java
java rsvp

### Classes
Class: Invatation
Class Details: Template for differnt types of invatations
Operation: Based on the event type, a particular invtation will be created (Birthday, Grdauation, Hangou, Wedding)

Class: RSVPNotifier
Class Details: Main interface with client. Holds list on events
Operation: Can register new events, send invatations to guests, provide event statistic breakdowns such as number of RSVP per event and number of event types.

Class: Guest
Class Details: Represents a guest that belongs to an event. Holds guests name, email, and RSVP status for that event 
Operation: Guests are created an added to an event. They can recieve invatations and RSVP to the event they belong to. 

Class: Event
Class Details: Holds many details about an event. The description, location, date, time, eventLink, eventType, host information, etc etc. Events also hold the event's guest list
Operation: Events are able to add guests to their invite list. Events can also get a custom invatation based on their event type. Can send out RSVP invatations to their list of guests, and also provide metrics on guests' RSVP responses. 