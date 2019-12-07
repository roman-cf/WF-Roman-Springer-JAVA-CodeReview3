package citybike;
import java.util.ArrayList;

public class Stations {
    private int stationID;
    private static int idCount = 1;
    private String location;
    private ArrayList<Bike> bikesIn;
    private int maxStorage = 4;

    public Stations(String location, ArrayList<Bike> bikesIn) {
        this.stationID = idCount++;
        this.location = location;
        this.bikesIn = bikesIn;
    }

    public ArrayList<Bike> getBikesIn() {
        return bikesIn;
    }

    public boolean addBike(Bike bike) {
        // bike in workshop cannot be applied to a station
        if (bikesIn.size() >= maxStorage || bike.getBikeStatus() == Bike.bikeStatus.inWorkshop) {
            return false;
        } else {
            this.bikesIn.add(bike);
            return true;
        }
    }

    public int getStationID() {
        return stationID;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    @Override
    public String toString() {
        return bikesIn.size()+" bikes in station# "+this.stationID+" "+this.location+ ": "+ bikesIn ;
    }

    public void rentBike(User userx, Bike bikex){

        boolean temp = bikesIn.contains(bikex);
        if(bikex.getBikeStatus()== Bike.bikeStatus.forRent && userx.getCurrentlyRentedBike()==null && temp){
            bikesIn.remove(bikesIn.indexOf(bikex));
            bikex.setBikeStatusConst(Bike.bikeStatus.inService);
            userx.setCurrentlyRentedBike(bikex);
            // check if bike in station is missing
        }else if (bikex.getBikeStatus()== Bike.bikeStatus.broken){
            System.out.println("Sorry, bike# "+bikex.getBikeID()+" is broken, you can't rent it.");
        }else if (userx.getCurrentlyRentedBike()!= null){
            System.out.println("you can rent(ride) only one bike");
        }else{
            System.out.println("Wrong User or wrong bike! Cannot proceed, ask admin.");
        }
    }


}
