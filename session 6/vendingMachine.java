
interface State {
    public void execute(VendingInputParams inputParams) throws Exception;
}

public class SelectState implements State {
    public SelectState() {
    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {
       // action
    }
}

public class PaymentState implements State {
    public PaymentState() {

    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {
        // action
    }
}


public class DeliverState implements State {
    private final Map<String, VendingItem> vendingItemsList;

    public DeliverState() {
        vendingItemsList = new HashMap<>;

    }

    @Override
    public void execute(VendingInputParams inputParams) throws Exception {

        VendingItem item = vendingItemsList.get(inputParams.getVendingItem);
        System.out.println(VendingItems);
    }
}


// enum encapsulating the type and size of spot
enum StateStatus {
    INITIAL,
    PAY,
    DELIVER,
    ERROR,
    DONE
}

public class VendingMachine {
    private User user;
    private State selectState;
    private State paymentState;
    private State deliverState;
    private StateStatus stateStatus;

    public VendingMachine() {
        this.selectState = new SelectState();
        this.paymentState = new PaymentState();
        this.deliverState = new DeliverState();

        this.stateStatus = INITIAL;
    }

    private void createUserSession() {

    }

    // vending machine is the central brain
    // and decision maker
    // error logic is exposed to upper layer
    public void selectItem(VendingInputParams vendingInputParams) throws Exception {

        createUserSession();

        while (getUserInput()) {
            switch (stateStatus) {
                case INITIAL: {
                    if (!isValid(inputParams.getVendingItem())) {
                        this.stateStatus = StateStatus.ERROR;
                    } else {
                        selectState.execute(vendingInputParams);
                        this.stateStatus = StateStatus.PAY;
                    }
                    break;
                }

                case PAY: {
                    if (!isValid(inputParams.getPaymentOption())) {
                        this.stateStatus = StateStatus.ERROR;
                    } else {
                        paymentState.execute(vendingInputParams);
                        this.stateStatus = StateStatus.DELIVER;
                    }
                    break;
                }

                case DELIVER: {
                    if (!isAvailable(inputParams.getVendingItem())) {
                        this.stateStatus = StateStatus.ERROR;

                    } else {
                        deliverState.execute(vendingInputParams);
                        this.stateStatus = StateStatus.DONE;
                    }
                    break;
                }
                case ERROR: {
                    throw new Excpetion("something went wrong, try again");
                }
            }
        }
    }
}