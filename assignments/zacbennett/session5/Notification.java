// One event can have many users.
// So event is the subject and the users are the observers.
// When the event states change, we notify all of the users/observers

// Note: It seems like this pattern is meant to represent a 1-many releationship. 
// In this example, it didn't make sense for one user to only subscribe to one event
// So I made it a many-many relationship. Not sure if that's an anti pattern or not. 

class User {
    private List<Event> eventList = new ArrayList<Event>;
    public User(Event event) {
        this.addEvent(event);
    }

    public void addEvent(Event event) {
        this.event.add(event);
        this.event.attach(this);
    }

    public void update(Event event) {
        if(eventList.contains(event)) {
            this.sendEmail(event)
        }
    }
}


class Event {
    private List<User> userSubscribers = new ArrayList<User>();
    private int state;

    public void setState(int state) {
        this.state = state;
        this.notifySubscribers();
    }

    private void notifySubscribers() {
        for(User user : userSubscribers) {
            user.update();
        }
    }

    public void attach(User user) {
        this.userSubscribers.add(user);
    }
}

class Client {
    public static void main() {
        Event event1 = new Event();
        User newUser = new User(event1);

        Event event2 = new Event();

        // newUser has two events on it
        newUser.addEvent(event2);

        // state of event 1 changed, newUser should only get email about event1
        event1.setState(2);
    }
}