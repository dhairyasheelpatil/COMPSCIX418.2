public class Event {
  private List<Observer> observers = new ArrayList<Observer>();
  private List<Observer> registrations = new ArrayList<Observer>();
  private List<Observer> reservations = new ArrayList<Observer>();
  private int state;
  public int getState() {
    return state;
  }
  public void setSTate(int state){
    this.state = state;
    notifyAllObservers();
  }
  public void attach (Observer observer) {
    observers.add(observer);
  }
  public void reg (Observer observer) {
    registrations.add(observer);
  }
  public void res (Observer observer) {
    reservations.add(observer);
  }
  public void notifyAllObservers() {
    for (auto observer : obbservers) {
      observer.update();
    }
  }
}

public abstrat class Observer {
  protected Event event;
  public abstract void update();
  public abstract void register();
  public abstract void reserve();

}

public class EventObserver extends Observer {
  public EventObserver(Event event) {
    this.event = event;
    this.event.attach(this);
  }
  @Override
  public void update(Event event) {
    if (event == _event) {
      this.event = _event;
      this.event.attach(this);
    }
  }
  @Override
  public void register(Event event) {
    this.event.reg(this);
  }
  @Override
  public void reserve(Event event) {
    this.event.res(this);
  }

}
