package citybike;

import java.util.Date;

public class Rent {
    private int bikeID;
    private Date RentStart;
    private Date RentEnd;

    public Rent(int bikeID, Date rentStart, Date rentEnd) {
        this.bikeID = bikeID;
        RentStart = rentStart;
        RentEnd = rentEnd;
    }
}
