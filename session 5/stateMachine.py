class StateMachine:
    def __init__(self, initialState):
        self.currentState = initialState
        self.currentState.run()
    def runAll(self, inputs):
        for i in inputs:
            self.currentState = self.currentState.next(i)
            self.currentState.run()


class TCPAction:
    def __init__(self, action):
        self.action = action
    def __str__(self): return self.action
    def __cmp__(self, other):
        return cmp(self.action, other.action)

class Waiting(State):
    def run(self):
        print("Waiting: TCP connection")

    def next(self, input):
        if input == TCPAction.Established:
            return TCPAction.Connect
        return TCPAction.Waiting

class Connect(State):
    def run(self):
        print("Connect: Connect TCP connection")

    def next(self, input):
        if input == TCPAction.Connect:
            return TCPAction.Closed
        if input == TCPAction.Closed:
            return TCPAction.Terminal
        return TCPAction.Connect

class Terminal(State):
    def run(self):
        print("Terminal: Terminal TCP connection")

    def next(self, input):
        return TCPAction.Terminal