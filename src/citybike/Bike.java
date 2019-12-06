package citybike;

public class Bike {
    private int bikeID;
    private String bikeColor;
    public enum bikeStatus {forRent, inService, inWorkshop,broken };
    private bikeStatus bikeStatusConst;

    public Bike(String bikeColor, bikeStatus bikeStatusConst) {
        this.bikeColor = bikeColor;
        this.bikeStatusConst = bikeStatusConst;
        this.bikeID = Integer.parseInt(String.valueOf(System.nanoTime() % Integer.MAX_VALUE));
    }

    public int getBikeID() {
        return bikeID;
    }


    public bikeStatus getBikeStatus() { return bikeStatusConst; }

    public void setBikeStatusConst(bikeStatus bikeStatusConst) {
        this.bikeStatusConst = bikeStatusConst;
    }

    @Override
    public String toString() {
        return "BikeID " + bikeID + " is " + bikeStatusConst;
    }
}
