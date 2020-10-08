import java.util.*;
import java.io.*;

class rsvp {

    enum EventTypes {
        Birthday,
        Wedding,
        Graduation,
        Hangout
    }

    static class Invatation {
        String invatationString;
        Invatation(Event event) {
            invatationString = ("Event RSVP for: " + event.getEventDesciption() + "\n" +
                                "Location: " + event.getEventVenue() + "\n" +
                                "Date: " + event.getEventDate() + "\n" +
                                "Time: " + event.getEventTime());
        }

        String getInvatationString() {
            return "You are invited to this event. Please RSVP, information below.\n" + this.invatationString;
        }
    }
    
    static class Birthday extends Invatation {
        Birthday(Event event) {
            super(event);
        }

        String getInvatationString() {
            return "Birthdays only come once a year! Its time to celebrate\n" + this.invatationString;
        }
    }
    
    static class Wedding extends Invatation {
        Wedding(Event event) {
            super(event);
            // TODO Auto-generated constructor stub
        }

        String getInvatationString() {
            return "Love is in the air! Please join us in celebration\n" + this.invatationString;
        }
    }

    static class Graduation extends Invatation {
        Graduation(Event event) {
            super(event);
            // TODO Auto-generated constructor stub
        }

        String getInvatationString() {
            return "Another year older, another year wiser! Please join us in festivities\n" + this.invatationString;
        }
    }

    static class Hangout extends Invatation {
        Hangout(Event event) {
            super(event);
            // TODO Auto-generated constructor stub
        }

        String getInvatationString() {
            return "Hey! its been a while huh? Lets catch up!\n\n" + this.invatationString;
        }
    }


    static class RSVPNotifier {
        ArrayList<Event> events = new ArrayList<Event>();
        
        RSVPNotifier() {}

        void register(Event event) {
            events.add(event);
        } 
        void sendRSVP() {
            for(Event event: events) {
                System.out.print("Event RSVP for: " + event.getEventDesciption() + "\n" +
                                "Location: " + event.getEventVenue() + "\n" +
                                "Date: " + event.getEventDate() + "\n" +
                                "Time: " + event.getEventTime() + "\n");
                event.sendEventRSVP();
                
            }
        }
    }

    static class Guest {
        private String name;
        private String email;
        private String RSVP;
        Guest(String name, String email) {
            this.name = name;
            this.email = email;
            this.RSVP = null;
        } 

        String getRSVP() {
            return this.RSVP;
        }

        void sendGuestRSVP(Invatation invatation) {
            if (this.RSVP == null) {
                System.out.println("\n" + invatation.getInvatationString() + "\nPlease RSVP " + this.name + " (" + this.email + ")" );
            }
            else{
                System.out.println("\n" + invatation.getInvatationString() + this.name + " has already RSVP: " + this.RSVP );
            }
        }
        void guestRSVPYes(Event event) {
            System.out.println("Alert! " + event.getHostName() + "(" + event.getHostEmail() + "), " + this.name + " Has RSVP: Yes");
            this.RSVP = "Yes";
        }

        void guestRSVPNo(Event event) {
            System.out.println("Alert! " + event.getHostName() + "(" + event.getHostEmail() + "), " + this.name + " Has RSVP: No");
            this.RSVP = "No";
        }

        String getName() {
            return this.name;
        }

        String getEmail() {
            return this.email;
        }
    }

    static class Event {
        private String desciption;
        private String venue;
        private String date;
        private String time;
        private String eventLink;
        private int numOfGuests;
        private EventTypes eventType;
        private Guest host;
        ArrayList<Guest> guests = new ArrayList<Guest>();
        Event(String desciption, String venue, String date, String time, String eventLink, int numOfGuests, EventTypes eventType, Guest host) {
            this.desciption = desciption;
            this.venue = venue;
            this.date = date;
            this.time = time;
            this.eventLink = eventLink;
            this.numOfGuests = numOfGuests;
            this.eventType = eventType;
            this.host = host;
        }
        void addGuest(Guest guest) {
            guests.add(guest);
        }
        
        public ArrayList<Guest> getGuestList(){
            return this.guests;
        }

        public String getEventType(){
            return this.eventType.toString();
        }

        public String getEventDesciption() {
            return this.desciption;
        }

        public String getEventVenue() {
            return this.venue;
        }

        public String getEventDate() {
            return this.date;
        }

        public String getEventTime() {
            return this.time;
        }

        public String getHostName() {
            return this.host.getName();
        }

        public String getHostEmail() {
            return this.host.getEmail();
        }

        Invatation getInvatation() {
            switch (this.eventType.toString()) {
                case "Birthday":
                  return new Birthday(this);
                case "Wedding":
                  return new Wedding(this);
                case "Graduation":
                  return new Graduation(this);
                case "Hangout":
                  return new Hangout(this);
                default:
                  return new Invatation(this);
            }
        }
        public void sendEventRSVP(){
            for(Guest guest: guests) {
                if (guest.getRSVP() == null) {
                    guest.sendGuestRSVP(getInvatation());
                }
            }
        }

        void getHostInfo() {
            System.out.println(this.host.getName() + " is (" + this.desciption + ") this event's host.\nReachable at " + this.host.getEmail());
        }
    }

//String desciption, String venue, String Date, String Time, String eventLink, int numOfGuests, EventTypes eventType, Guest host
    public static void main(String[] args) {
        RSVPNotifier notifier = new RSVPNotifier();
        Event myEvent = new Event("MyBday","Claude House","1/25/88","1pm","www.claude.com",10,EventTypes.Birthday, new Guest("Claude Phan", "claude.phan@gmail.com"));
        myEvent.addGuest(new Guest("Andrew Phan", "andrew.phan@gmail.com"));
        myEvent.addGuest(new Guest("Grace Phan", "grace.phan@gmail.com"));
        notifier.register(myEvent);

        System.out.println("-- Sending out RSVP Invatations ---");
        notifier.sendRSVP();
        
        System.out.println("\nGuest Accepted");
        myEvent.getGuestList().get(0).guestRSVPYes(myEvent);

        System.out.println("\n-- Sending out RSVP Invatations ---");
        notifier.sendRSVP();
    }
}