
interface State {
    public void execute(VendingInputParams inputParams);
}

interface ErrorStateHandler {
    public void handleError() throws Exception;
}

public class ErrorState implements ErrorStateHandler {
    @Override
    public void handleError() throws Exception {
        throw new Exception("Operation failed, try again");
    }

}

public class SelectState implements State {
    State paymentState;
    ErrorState errorState;

    public SelectState() {
         this.paymentState = new PaymentState();
         this.errorState = new ErrorState();
    }

    @Override
    public void execute(VendingInputParams inputParams) {
        if (!isValid(inputParams.getVendingItem())) {
            errorState.handleError();
        }

        paymentState.execute(inputParams);
    }
}

public class PaymentState implements State {
    State deliverState;
    ErrorState errorState;

    public PaymentState() {
        this.deliverState = new DeliverState();
        this.errorState = new ErrorState();
    }

    @Override
    public void execute(VendingInputParams inputParams) {
        if (!isValid(inputParams.getPaymentOption())) {
            errorState.handleError();
        }

        deliverState.execute(inputParams);
    }
}


public class DeliverState implements State {
    private final Map<String, VendingItem> vendingItemsList;
    State errorState;

    public DeliverState() {
        this.vendingItemsList = new HashMap<>;
        this.errorState = new ErrorState();
    }

    @Override
    public void execute(VendingInputParams inputParams) {
        if (!isAvailable(inputParams.getVendingItem())) {
            errorState.handleError();
        }
        VendingItem item = vendingItemsList.get(inputParams.getVendingItem);
        System.out.println(item);
    }
}


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