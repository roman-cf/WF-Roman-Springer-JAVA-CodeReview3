package citybike;
import citybike.Bike;

import java.util.ArrayList;

public class Stations {
    private int stationID;
    private static int idCount = 1;
    private String location;
    private ArrayList<Bike> bikesIn;

    public Stations(String location, ArrayList<Bike> bikesIn) {
        this.stationID = idCount++;
        this.location = location;
        this.bikesIn = bikesIn;
    }

    public ArrayList<Bike> getBikesIn() {
        return bikesIn;
    }

    public boolean addBike(Bike bike) {
        if (bikesIn.size() > 6) {
            System.out.println("Sorry, Station is full.");
            return false;
        } else {
            this.bikesIn.add(bike);
            return true;
        }
    }

    public int getStationID() {
        return stationID;
    }

    @Override
    public String toString() {
        return bikesIn.size()+" bikes in station# "+this.stationID+" "+this.location+ ": "+ bikesIn ;
    }

    public void rentBike(User userx, Bike bikex){
        if(bikex.getBikeStatus()== Bike.bikeStatus.forRent){
            bikesIn.remove(bikesIn.indexOf(bikex));
            bikex.setBikeStatusConst(Bike.bikeStatus.inService);
            userx.setCurrentlyRentedBike(bikex);

        }else if (bikex.getBikeStatus()== Bike.bikeStatus.broken){
            System.out.println("Sorry, bike# "+bikex.getBikeID()+" is broken, you can't rent it.");
        }else {
            System.out.println("Wrong User or wrong bike! Cannot proceed, ask admin.");
        }
    }


}
