
// lightweight interface
// each state encaspulates its successor
interface State {
    public void execute(VendingInputParams inputParams) throws Exception;
}

public class SelectState implements State {
    State paymentState;

    public SelectState() {
         this.paymentState = new PaymentState();
    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {
        if (!isValid(inputParams.getVendingItem())) {
            throw new Exception("User chose an invalid item, please select again");
        }

        paymentState.execute(inputParams);
    }
}

public class PaymentState implements State {
    State deliverState;

    public PaymentState() {
        this.deliverState = new DeliverState();
    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {
        if (!isValid(inputParams.getPaymentOption())) {
            throw new Exception("User chose an invalid payment card, please pay again");
        }

        deliverState.execute(inputParams);
    }
}


public class DeliverState implements State {
    private final Map<String, VendingItem> vendingItemsList;

    public DeliverState() {
        vendingItemsList = new HashMap<>;

    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {
        if (!isAvailable(inputParams.getVendingItem())) {
            throw new Exception("Item is not available or stuck, please try again");
        }
        VendingItem item = vendingItemsList.get(inputParams.getVendingItem);
        System.out.println(item);
    }
}

// lighther vendign machine simpler logic
// cleaner approach, drawback is each state has to be aware of the next state
public class VendingMachine {
    private User user;
    private State selectState;

    public VendingMachine() {
        this.selectState = new SelectState();
    }

    private void createUserSession() {

    }

    public void selectItem() {
        createUserSession();

        selectState.execute();
    }
}