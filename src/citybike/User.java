package citybike;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;


public class User {
    private int userID;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private String name;
    private String surname;
    private Bike currentlyRentedBike;
    private ArrayList<Rent> rental;

    public User(String name, String surname) {
        this.userID = atomicInteger.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.currentlyRentedBike = currentlyRentedBike;
        this.rental = new ArrayList<Rent>();
    }
    public void initRental(int bikeID){
        this.rental.add(new Rent(bikeID));
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
                rental.get(rental.size()-1).rentEnd();
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
