class VendingMachine {
    private VendingMachineState _state;
    private Snack selectedSnack;
    private HashMap<String, Snack> selection;
    
    public VendingMachine() {
        this.setState(new SelectionState());
    }
 
    public HashMap<String, Snack> getSelection() {
        return this.selection;
    }

    private void setState(VendingMachineState newState) {
        this._state = newState;
    }

    private VendingMachineState getState() {
        return this._state;
    }

    public void cancel() {
        this.setState(new SelectionState());
        this.selectedSnack = null;
    }

    public Snack makeSelection(String selection) {
        if(!(this.getState() instanceof SelectionState)) {
            this.getState().printStatus();
            throw new Exception('Incorrect state!');
        }
 
        if(this.selection.containsKey(selection)) {
            Snack selectedItem = this.selection.get(selection); 
            this.selectedItem = selectedItem;

            this.setState(new PaymentState());
            return selectedItem;
        } else {
            throw InvalidArgumentException('Selection does not exist!');
        }
    }

    private float getPrice(Snack selectedItem) {
        return this.prices.get(selectedItem);
    }

    public void pay(PaymentMethod paymentMethod) {
        if(!(this.getState() instanceof PaymentState)) {
            this.getState().printStatus();
            throw new Exception('Incorrect state!');
        }

        Float price;
        if(this.selectedItem == null) {
            throw new Exception('No item selected!');
        } else {
            price = this.getPrice(this.selectedItem);
        }
        
        try {
            paymentMethod.charge(price);
            this.setState(new DeliveryState());
        } catch {
            throw new Exception('Payment Failed')
        }
    }

    public void deliver() {
        if(!(this.getState() instanceof DeliveryState)) {
            this.getState().printStatus();
            throw new Exception('Incorrect state!');
        }

        this.selectedItem.deliver();
    }
}

public interface VendingMachineState {
    void next(VendingMachine vendingMachine);
    void prev(VendingMachine vendingMachine);
    void printStatus();
}

public class SelectionState implements VendingMachineState {
    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setState(new PaymentState());
    }
 
    @Override
    public void prev(VendingMachine vendingMachine) {
        this.printStatus();
    }
 
    @Override
    public void printStatus() {
        System.out.println("Please select a snack");
    }
}

public class PaymentState implements VendingMachineState {
    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setState(new DeliveryState());
    }
 
    @Override
    public void prev(VendingMachine vendingMachine) {
        vendingMachine.setState(new SelectionState());
    }
 
    @Override
    public void printStatus() {
        System.out.println("Please select a snack");
    }
}

public class DeliveryState implements VendingMachineState {
    @Override
    public void next(VendingMachine vendingMachine) {
        this.printStatus();
    }
 
    @Override
    public void prev(VendingMachine vendingMachine) {
        vendingMachine.setState(new SelectionState());
    }
 
    @Override
    public void printStatus() {
        System.out.println("Snack has been delivered... hopefully");
    }
}
