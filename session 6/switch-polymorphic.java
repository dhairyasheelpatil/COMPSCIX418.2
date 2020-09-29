
Map<> getHoneyRate(bee) {
  return createBee(bee).getHoneyRate();
}

Map<> getFlyingSpeed(bee) {
   return createBee(bee).getSpeed();
}

  Bee createBee(bee) {
    switch (bee.type) {
    case 'BumbleBee':
      return new BumbleBee();
    case 'HoneyBee':
      return new HoneyBee();
    case 'MiningBee':
      return new MiningBee();
    default:
      return new Bee();
    }
  }

class Bee {
  boolean isLight;
  double weight;
 
  Bee() {

  }
}

class BumbleBee extends Bee {
 double getSpeed() {
  return 35;
 }

 String getHoneyRate() {
  return "low";
 }

}

class HoneyBee extends Bee {
  double getSpeed() {
   return 40 - 2 * bee.weight;
 }
 String getHoneyRate() {
  return (bee.count > 2) ? "low" : "high";
 }
}

class MiningBee extends Bee {
   double getSpeed() {
    return (this.isLight ? 10 + this.weight / 10 : 0;
   }
   String getHoneyRate() {
     return (this.isLight ? 10 + this.weight / 10 : 0;
   }
}