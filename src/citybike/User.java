package citybike;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private int userID;
    private String name;
    private String surname;
    private Bike currentlyRentedBike;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public User(String name, String surname) {
        this.userID = atomicInteger.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public int getUserID() {
        return userID;
    }

    public void setCurrentlyRentedBike(Bike currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public Bike getCurrentlyRentedBike() {
        return currentlyRentedBike;
    }

    public void returnBike(Stations stationx) {
        if(currentlyRentedBike!=null) {
            Bike bikex = this.currentlyRentedBike;
            if (stationx.addBike(bikex)) {
                currentlyRentedBike = null;
                bikex.setBikeStatusConst(Bike.bikeStatus.forRent);
            } else {
                System.out.println("Sorry, you can't return bike# " + bikex.getBikeID() + " , because station " + stationx.getLocation() + " is full! (" + stationx.getMaxStorage() + ")");
            }
        }else{
            System.out.println(" you have no bike you can return");
        }
    }


        @Override
    public String toString() {
        return "User " + name + " " + surname +  ", currentlyRentedBike " + currentlyRentedBike ;
    }
}
