// recursion
class Timer {

	public void countDown(int counter) {
		if (counter == 0)
			return;
		countDown(counter--);
	}
}

// delegation
class VicePresidentOfSales {
  public:
  	 void increaseQuarterlySales();
 };

 class CEO {
 	VicePresidentOfSales vpOfSales;

 	void increaseProfits() {
 		vpOfSales.increaseQuarterlySales();
 	}
 }

 @interface Painter {}
 - (void) paintCar: (car) theCar;
 @end


class Painter {
   var theCar: Car
   paintCar(car: Car) {
      self.theCar = car
   }
}
// redirection
class PaintShopManager {
   var theCar: Car
   paintCar(car: Car) {
      self.subPainter.paintCar(car)
   }
}


// conglomeration
class Timer {
	void ring();

	public void countDown(int counter) {
		if (counter == 0)
			return;
		ring();
	}
}

