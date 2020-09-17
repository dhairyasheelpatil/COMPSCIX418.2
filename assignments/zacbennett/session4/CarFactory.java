// This is using a factory to hide the complexity of creating the car objects  as well as the decorator to override certain behaviors of the 
//  car object

public class Car {
    public String color;
    public float zeroToSixty;
    public boolean isComfortable;

    public Car(String color) {
        this.color = color;
        this.zeroToSixty = 6.4;
        this.isComfortable = false;
    }

    public void drive() {
        // This is silly and I'm sorry
        System.out.print('vroom vroom');
    }

    // getters and setters for the instance vars below...

}

public class CarDecorator extends Car{
    protected Car car;

    public CarDecorator(Car carToBeDecorated){
        this.carToBeDecorated = carToBeDecorated;
    }

    public void drive(){
        carToBeDecorated.drive();
    }
}

public class SportsCarDecorator extends CarDecorator{

    public SportsCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void drive() {
        System.out.print('vroom vroom vroom');
    }

}


public class LuxuryCarDecorator extends CarDecorator{

    public LuxuryCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void drive() {
        System.out.print('vroom');
    }

}

// Factory to utilize our decorators
public class CarFactory {
    public static Car buildCar(String type, String color) {
        switch (type) {
            case "luxury":
                Car car = new Car(color);
                return new LuxuryCarDecorator(car);
            case "sports":
                Car car = new Car(color);
                return new SportsCarDecorator(car);
            default:
                return new Car(color);
        }
    }

    // meant to decorate an existing car
    public static Car buildCar(Car car) {
        switch (type) {
            case "luxury":
                return new LuxuryCarDecorator(car);
            case "sports":
                return new SportsCarDecorator(car);
            default:
                return car;
        }
    }
}

public static void main(String[] args) {
    Car luxuryCar = CarFactory.buildCar("blue", "luxury");

    Car luxurySportsCar = new SportsCarDecorator(luxuryCar);
}
