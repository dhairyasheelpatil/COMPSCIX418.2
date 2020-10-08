//[SM] this is great, this is the correct implementation of the decorator class
// defining a default behavior inside the carBase class is well thought
public interface Car {
  String getCar();
};

public abstract class carBase : Car {
  private String carType;
  private Float price;
  private int HP;
  private int doors;

  public carBase(String carType, Float price, int HP, int doors) {
    this.carType = carType;
    this.price = price;
    this.HP = HP;
    this.doors = doors;
  }

  public virtual String getCar() {
    return String.format("This base car is %d door %s, with a cost of %f. Has %d horsepower", this.doors, this.carType, this.price, this.doors);
  }

}

public abstract class carDecorator {
  private Car _car;
  public carDecorator(Car car) {
    _car = carType, price, HP, doors;
  }
  String getCar() {
    return Car.getCar();
  }
}

public class compactCarDecorator : carDecorator {
  public compactCarDecorator(Car car) { String carType, Float price, int HP, int doors }
  public override string getCar() {
    return  String.format("This is a %d door %s car, with a cost of %f. Perfect for those on a budget!", this.doors, this.carType, this.price);
  }
}

public class sportsCarDecorator : carDecorator {
  public compactCarDecorator(Car car) { String carType, Float price, int HP, int doors }
  public override string getCar() {
    return  String.format("This %s car, has %d horsepower. Great for those looking for performance!", this.carType, this.HP);
  }
}

public class luxuryCarDecorator : carDecorator {
  public compactCarDecorator(Car car) { String carType, Float price, int HP, int doors }
  public override string getCar() {
    return  String.format("This is a %d door %s car, with a cost of %f and has %d horsepower", this.doors, this.carType, this.price, this.HP);
  }

}
