
public class Address {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private int counter;

public Address(String firstName, String lastName, String street, String city, String state, String zip, int counter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.counter = 0;
        }
}


public class AddressBuilder {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private int counter;


    public AddressBuilder() {
    }

    public AddressBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AddressBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    private Address() {

    }
   ...
    public Address build() {
        // the builder is in the Address class, we can invoke its private constructor
        Address address = new Address();
        address.firstName = firstName;
        address.lastName = lastName;
        address.street = street;
        address.city = city;
        address.state = state;
        address.zip = zip;
        address.counter = 0;

        return address;
    }
}

//Client Side:
//
//        Address address = new AddressBuilder().setFirstName("name").setLastName("last").build();
////
////        AddressBuilder addressBuilder = new AddressBuilder();
////        addressBuilder.set
//        Address address = new Address(........);