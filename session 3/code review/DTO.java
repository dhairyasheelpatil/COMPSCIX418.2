public class Address {
     private String street;
     private String city;
     private String state;
     private String zip;

     private int counter;
 
     public Address(String street, 
                     String city, String state, String zip, int counter) {
       this.street = street;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.counter = countInCA();
     }
 
     public String getStreet() {
       return street;
     }
 
     public String getStreetExtra() {
       return streetExtra;
     }
 
     public String getCity() {
       return city;
     }
 
     public String getState() {
       return state;
     }
 
    public String getZip() {
      return zip;
    }

    private int countInCA() {
    	if (state.equals("CA")) {
    		counter.getAndIncrement();
    	}	
    	return counter;
    }
 }

 public class DTO {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0); 

        Address userAddress1 = new Address("street1", "CA", "91267", counter);
        Address userAddress2 = new Address("street2", "CA", "95128", counter);
        Address userAddress2 = new Address("street3", "NY", "91800", counter);

        System.out.println("Percentage in CA" + String. format("%.2f", (counter/3) * 100));
    }
}