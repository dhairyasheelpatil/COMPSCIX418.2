Map<> getHoneyRate(bees) {
  return new Map(bees.map(b => [b.name, honeyRate(b)]));
}

Map<> getFlyingSpeed(bees) {
  return new Map(bees.map(b => [b.name, flyingSpeed(b)]));
}

// flat model, how can we restructure
String honeyRate(bee) {
  switch (bee.type) {
  case 'BumbleBee':
    return "low";
  case 'HoneyBee':
    return (bee.count > 2) ? "low" : "high";
  case 'MiningBee':
    return (bee.wings > 2) ? "medium" : "low";
  default:
    return "unknown";
  }
}

Double flyingSpeed(bee) {
  switch (bee.type) {
  case 'BumbleBee':
    return 35;
  case 'HoneyBee':
    return 40 - 2 * bee.weight;
  case 'MiningBee':
    return (bee.isLight) ? 10 + bee.weight / 10 : 0;
  default:
    return 0;
  }
}