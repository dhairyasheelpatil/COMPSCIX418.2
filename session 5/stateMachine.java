// decentralized way, letting states transition themselves internall
// disadvantag: introduces a level of dependency between subclasses
// one state must know about at least one other state
public interface TCPState {

    void next(State state);
    void prev(State state);
    void printStatus();
}

public class TCPInitialConnectionState implements TCPState {

    @Override
    public void next(State state) {
        state.setState(new TCPEstablishedConnectionState());
    }

    @Override
    public void prev(State state) {
        System.out.println("The connection is in its inital state.");
    }

    @Override
    public void printStatus() {
        System.out.println("connection initiated.");
    }
}



public class TCPEstablishedConnectionState implements TCPState {

    @Override
    public void next(State state) {
        state.setState(new TCPConnectedConnectionState());
    }

    @Override
    public void prev(State state) {
        state.setState(new TCPInitialConnectionState());
    }

    @Override
    public void printStatus() {
        System.out.println("connection established.");
    }
}

// another way
// client side: if the transition criteria is fixed, moved to the context, more appropriate
    public static void main(String[] args) {

      TCPInitialConnectionState tcpConnectionState = new TCPInitialConnectionState();
      if (tcpConnectionState.connected()) {
            TCPEstablishedConnectionState tcpEstablishedConnectionState = new TCPEstablishedConnectionState();
      }
    }

