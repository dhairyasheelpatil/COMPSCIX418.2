package refactor;

import java.util.List;

// Inheritance should be used here. This will avoid repeated code and make
// the code more readable. UserRegistration should be the super class and
// PCRegistration and MacBookRegistration should extend UserRegistration.
// Method purchase() can be a common method in the super class because it is
// the same behavior in PCRegistration and MacBookRegistration. The same apply
// to receipt() method. PCRegistration and MacBookRegistration both have the method
// getPrice(). This can be a common method in the super class as well.

public class UserRegistration {
    public List<PCRegistration> _pcRegistrations;
    public List<MacBookRegistration> _macBookRegistrations;
    public String _userName;

    public UserRegistration(String userName) {
        _userName = userName;
    }

    ;

    public UserRegistration() {
    }

    ;

    // Repeated method for purchase
    public void purchase(PCRegistration pcRegistration) {
        _pcRegistrations.add(pcRegistration);
    }

    ;

    public void purchase(MacBookRegistration macRegistration) {
        _macBookRegistrations.add(macRegistration);
    }

    ;

    public String receipt() {
        String receipt;
        // Repeated code for getting the receipt
        for (pcRegistration in _pcRegistrations) {
            receipt += String.valueOf(pcRegistration.getPrice()) + ","
        }
        for (macBookRegistration price in _macBookRegistrations){
            receipt += String.valueOf(macBookRegistration.getPrice()) + ","
        }
        return receipt.substring(0, receipt.length() - 1);
    }

    ;
}

// PCRegistration should extend UserRegistration
public class PCRegistration {
    public String _name;
    public double _price;

    public PCRegistration(String name) {
        _name = name;
    }

    ;

    public PCRegistration() {
    }

    ;

    public String name() {
        return _name;
    }

    public String toString() {
        return _name;
    }

    // getPrice should be in the super class
    public double getPrice() {
        return _price;
    }
}

// MacBookRegistration should extend UserRegistration
public class MacBookRegistration {
    public String _name;
    public double _price;

    public MacBookRegistration(String name) {
        _name = name;
    }

    public MacBookRegistration() {
    }

    ;

    public String name() {
        return _name;
    }

    public String toString() {
        return _name;
    }

    public double getPrice() {
        return _price;
    }
}
