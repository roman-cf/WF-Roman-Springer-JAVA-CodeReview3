package citybike;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Bike bike1 = new Bike("white", Bike.bikeStatus.forRent);
        Bike bike2 = new Bike("red", Bike.bikeStatus.forRent);
        Bike bike3 = new Bike("white", Bike.bikeStatus.broken);
        Bike bike4 = new Bike("white", Bike.bikeStatus.forRent);
        Bike bike5 = new Bike("red", Bike.bikeStatus.forRent);
        Bike bike6 = new Bike("black", Bike.bikeStatus.inWorkshop);
        Bike bike7 = new Bike("black", Bike.bikeStatus.forRent);
        Bike bike8 = new Bike("white", Bike.bikeStatus.forRent);
        Bike bike9 = new Bike("red",Bike.bikeStatus.inWorkshop);
        Bike bike10 =new Bike("red", Bike.bikeStatus.forRent);

        HashMap<Integer,Bike> bikeMap = new HashMap<>();
        bikeMap.put(bike1.getBikeID(),bike1);
        bikeMap.put(bike2.getBikeID(),bike2);
        bikeMap.put(bike3.getBikeID(),bike3);
        bikeMap.put(bike4.getBikeID(),bike4);
        bikeMap.put(bike5.getBikeID(),bike5);
        bikeMap.put(bike6.getBikeID(),bike6);
        bikeMap.put(bike7.getBikeID(),bike7);
        bikeMap.put(bike8.getBikeID(),bike8);
        bikeMap.put(bike9.getBikeID(),bike9);
        bikeMap.put(bike10.getBikeID(),bike10);

        /*for(int entry :bikeMap.keySet()){
            System.out.println((entry) + ": " +  bikeMap.get(entry));
        }*/

        // generate Station object - put them in a HashMap
        ArrayList<Bike> bikesInStation1 = new ArrayList<>();
        Stations station1 = new Stations("Mariahilferstrasse",bikesInStation1);
        ArrayList<Bike> bikesInStation2 = new ArrayList<>();
        Stations station2 = new Stations("Praterstern",bikesInStation2);
        ArrayList<Bike> bikesInStation3 = new ArrayList<>();
        Stations station3 = new Stations("Karlsplatz",bikesInStation3);
        ArrayList<Bike> bikesInStation4 = new ArrayList<>();
        Stations station4 = new Stations("Hauptbahnhof",bikesInStation4);

        HashMap<Integer, ArrayList<Bike>> stationMap = new HashMap<>();
        stationMap.put(station1.getStationID(),station1.getBikesIn());
        stationMap.put(station2.getStationID(),station2.getBikesIn());
        stationMap.put(station3.getStationID(),station3.getBikesIn());
        stationMap.put(station4.getStationID(),station4.getBikesIn());


        // put 3 bikes in Station1, and put 4 bikes in Station2)
        station1.addBike(bike10);
        station1.addBike(bike2);
        station1.addBike(bike3);
        station2.addBike(bike7);
        station2.addBike(bike4);
        station2.addBike(bike1);
        station2.addBike(bike3);
        System.out.println(station1.toString());

        //Create 4 users
        User user1 = new User("Tom","Malcher");
        User user2 = new User("max", "Muster");
        User user3 = new User("Phillip", "Dentaner");
        User user4 = new User("Daivd", "Baumgartner");

        // UserZ rents a bike bikeX from stationY1
        System.out.println("\n rent bike from station#1---------------------------------");
        station1.rentBike(user3,bike10);

        // bikeX is removed from the data of that Station, and connected to a userZ
        System.out.println(user3.toString());
        System.out.println(station1.toString());

        // userZ returns a bike to stationY2
        System.out.println("\n return bike---------------------------------");
        user3.returnBike(station2);
        System.out.println(user3.toString());
        System.out.println(station2.toString());

        System.out.println("\n rent another bike---------------------------------");
        station1.rentBike(user3,bike2);
        System.out.println(station1.toString());


    }
}
