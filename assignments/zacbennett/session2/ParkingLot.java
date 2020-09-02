class ParkingLot {
    List<Level> levels;

    ParkingLot(Int levels, Int sizeOfLevel) {
        this.levels = new List<>();

        for (int i = 0; i < levels; i++) {
            this.levels.add(new Level(sizeOfLevel))
        }
    }

    public Spot getNextOpenSpot() {
        for(Level level : this.levels) {
            Spot spot = level.occupySpot();
            if(!spot.isNull()) {
                return spot;
            }
        }
        throw Exception('No open slots in parking lot')
    }
}


class Level {
    List<Spot> spots;
    Int totalSpots;

    Level(Int totalSpots) {
        for (int i = 0; i < totalSpots; i++) {
            this.addSpot();
        }
        this.totalSpots = totalSpots;
    }

    public Spot addSpot() {
        SpotBuilder spotBuilder = new SpotBuilder;
        Spot spot = spotBuilder.setSize("compact").setIsDisabled(false).setIsAvailable(true).build();

        return spot
    }

    public Spot occupySpot() {
        for (Spot spot : spots) {
            if(spot.isAvailable) {
                spot.occupySpot();

                this.totalSpots--;
                return spot
            }
        }
        return null
    }

    public Spot freeUpSpot(spotNum) {
        Spot spot = spots.get(spotNum)
        spot.freeUpSpot();

        this.totalSpots++;
        return spot
    }
}

// Could also use a factory here to generate different types of spots, disabled spots, huge spots, etc
class SpotBuilder {
    String size;
    Boolean isDisabled;
    Boolean isAvailable;

    public String setSize(size) {
        this.size = size;
        return this;
    }

    public String setIsDisabled(isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    public Int setIsAvailable(isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }
    public Spot build() {
        Spot spot = new Spot();

        spot.setSize(this.size);
        spot.setIsDisabled(this.isDisabled);
        spot.setIsAvailable(this.isAvailable);

        return spot;
    }
}

class Spot {
    String size;
    Boolean isDisabled;
    Boolean isAvailable;

    public String getSize() {
        return this.size;
    }
    public String setSize(size) {
        this.size = size;
    }

    public Boolean getIsDisabled() {
        return this.isDisabled;
    }
    public Boolean setIsDisabled(isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getIsAvailable() {
        return this.IsAvailable;
    }
    public void occupySpot() {
        this.setIsAvailable(false);
    }
    public void freeUpSpot() {
        this.setIsAvailable(true);
    }
    public void setIsAvailable(IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
}