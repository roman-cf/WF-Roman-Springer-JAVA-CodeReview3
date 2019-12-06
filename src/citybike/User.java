package citybike;

public class User {
    private int userID;
    private String name;
    private String surname;
    private Bike currentlyRentedBike;

    public User(String name, String surname) {
        this.userID = Integer.parseInt(String.valueOf(System.nanoTime() % Integer.MAX_VALUE));
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

    public void returnBike( Stations stationx) {
        Bike bikex = this.currentlyRentedBike;
        if (stationx.addBike(bikex)) {
            currentlyRentedBike = null;
            bikex.setBikeStatusConst(Bike.bikeStatus.forRent);
        }
    }


        @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", currentlyRentedBike=" + currentlyRentedBike +
                '}';
    }
}
