class VendingMachine {
public:
  void CollectMoney(int money)
  void DispenseChange(String itemID);
  void DispenseItem(String itemID);
  void Cancel();
private:
  VendingMachineState* _vendingMachineState;
};

class VendingMachineState{
  private int collectedMoney
  private VendingMachine state;

  public void collectMoney(int money) {
      this.collectedMoney += money;
      this.state = setState(new CollectMoney(this.VendingMachine))
  }

  public int getCollectedMoney() {
      return this.collectedMoney;
  }

  public void setCollectedMoney(int money) {
      this.collectedMoney = money;
  }

  public int calculateChange(String itemID) {
      return collectedMoney - itemIDPrices.get(itemID);
  }

  public State getState() {
      return VendingMachineState* state;
  }

  public VendingMachine setState(VendingMachineState* state) {
      this.state = state;
      return this;
  }

  public void dispenseChange(String itemID) {
      this.state.dispenseChange(itemID);
  }

  public void dispenseItem(String itemID) {
      this.state.dispenseItem(itemID);
  }

  public void cancel() {
      this.state.cancel();
  }
}

class CollectMoney: public VendingMachineState {
  public:
    CollectMoney(VendingMachineState vendingMachineState ) {
      this.vendingMachineState = vendingMachineState
    }
  private:
    VendingMachineState* _vendingMachineState;
}

class DispenseChange: public VendingMachineState {
  public:
    DispenseChange(VendingMachineState vendingMachineState ) {
      this.vendingMachineState = vendingMachineState
    }
  private:
    VendingMachineState* _vendingMachineState;
}

class DispenseItem: public VendingMachineState {
    DispenseItem(VendingMachineState vendingMachineState ) {
      this.vendingMachineState = vendingMachineState
    }

    public void dispenseItem(String itemID) {
        System.println.out("Dispensing Item!")
        VendingMachineState.setState(New Cancel(VendingMachineState))
    }

    public void dispenseChange(String itemID) {
      System.println.out("Dispensing Item!")
      dispenseChange(String itemID)      
    }
  private:
    VendingMachineState* _vendingMachineState;
}

class Cancel: public VendingMachineState {
  Cancel(VendingMachineState vendingMachineState ) {
    this.vendingMachineState = vendingMachineState
  }

  public void cancel() {
    System.println.out("Transaction Canceled")
    VendingMachineState.setCollectedMoney(0)
    VendingMachineState.setState(New Cancel(VendingMachineState))
  }
  private:
    VendingMachineState* _vendingMachineState;
}
