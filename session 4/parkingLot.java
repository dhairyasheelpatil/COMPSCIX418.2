// enum encapsulating the type and size of spot
enum VehicleType {
    MOTORCYCLE(1, "motorcycle"),
    COMPACT(2, "compact"),
    VAN(3, "van"),
    EV(2, "electric");

    private int spots;
    private String type;

    VehicleType(int spots, String type) {
        this.spots = spots;
        this.type = type;
    }

    public int getSpots() { return spots; }

    public String getType() { return type; }
}

public class ParkingLot {
    // is this flexible enough?
    // protected why?
    protected final int levels = 10;
    protected ArrayList<ParkingLevel> parkingLevels = null;

    public ParkingLot() {
        this.parkingLevels = new ArrayList<ParkingLevel>();
        for (int i = 0; i < levels; i++) {
            this.parkingLevels.add(new ParkingLevel());
        }
    }

    public ArrayList<ParkingLevel> getAvailableLevels() {
        ArrayList<ParkingLevel> emptyParkingLevels = new ArrayList<ParkingLevel>();
        for (ParkingLevel parkingLevel : parkingLevels) {
            // delegating
            if (parkingLevel.getAvailableSpot() != null) {
                emptyParkingLevels.add(parkingLevel);
                break;
            }
        }
        return emptyParkingLevels;
    }

    // search for a particular type
    public ArrayList<ParkingLevel> getAvailableLevelsForType(VehicleType vehicleType) {

    }
}

public PaidParkingLot extends ParkingLot{
        public boolean pay(Vehicle vehicle, PaymentSource paymentSource) {

        }
}

public class ParkingLevel {
    // spot size
    private final int spots = 100;
    protected ArrayList<ParkingSpot> parkingSpots = null;

    public ParkingLevel() {
        parkingSpots = new ArrayList<ParkingSpot>();
        for (int i = 0; i < spots; i++) {
            this.parkingLevels.add(new ParkingSpot());
        }
    }

    public ParkinSpot getAvailableSpot() {
        ParkingSpot emptyParkingSpot = null;
        for (ParkingSpot parkingSpot : parkingSpot) {
            if (parkingSpot.isAvailable()) {
                emptyParkingSpot = parkingSpot;
                break;
            }
        }
        return emptyParkingSpot;
    }

    public ParkingSpot getAvailableSpotForType(VehicleType vehicleType) {
        ParkingSpot emptyParkingSpot = null;
        for (ParkingSpot parkingSpot : parkingSpot) {
            if (parkingSpot.isAvailable()) {
                emptyParkingSpot = parkingSpot;
                break;
            }
        }
        return emptyParkingSpot;
    }
}

public class ParkingSpot {
    private boolean empty;
    // default size for the spot
    private VehicleType vehicleType;
    private Vehicle vehicle;
    // extend to have a spot number, add level for payment

    public ParkingSpot() {
        this.empty = true;
        this.vehicleType = VehicleType.COMPACT;
    }

    public ParkingSpot(VehicleType vehicleType) {
        this.empty = true;
        this.vehicleType = vehicleType;
    }

    public void occupy(Vehicle vehicle) {
        this.empty = false;
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return this.empty == true;
    }

    public void occupy(VehicleType vehicleType, Vehicle vehicle) {
        // reusing logic
        occupy(vehicle);
        this.vehicleType = vehicleType;
    }
}

class PaidParkingSpot extends ParkingSpot {
    private int spotNumber;

    public PaidParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}

public abstract class Vehicle {
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleType type;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getType() {
        return type;
    }

    public void park(ParkingSpot parkingSpot) {
        parkingSpot.occupy();
    }
}

public class Van extends Vehicle {
    public Van() {
        spotsNeeded = VehicleType.VAN.getSpots();
        type = VehicleType.VAN.getType();
    }
}

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = VehicleType.COMPACT.getSpots();;
        type = VehicleType.COMPACT.getType();
    }
}

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = VehicleType.MOTORCYCLE.getSpots();;
        type = VehicleType.MOTORCYCLE.getType();
    }
}

// extend parking lot to be paid parking lot
// Business logic separate from data objects
// findSpot
// occupy
// leave
// throw an excption
// pay, how to extend the parking lot to be paid?
// payment manager delegation
// decorate parking spot with price
public class ParkingLotManager {
    private static ParkingLotManager _instance = null;

    private ParkingLotManager() {
    }

    public static ParkingLotManager getInstance() {
        if (_instance == null) {
            // instantiate once on demand
            _instance = new ParkingLotManager();
        }
        return _instance;
    }

    public static ParkingSpot findSpot(VehicleType type) {
    }

    public static PaidParkingSpot findPaidSpot(VehicleType type) {
    }
}

// client side
    public static void main(String[] args) {

        ParkingLotManager parkingLotManager = ParkingLotManager.getInstance();

        Vehicle myCar = new Car();
        ParkingSpot parkingSpot = parkingLotManager.findSpot(myCar.getType())
        if (parkingSpot != null) {
            parkingSpot.occupy(myCar);
        }

    }