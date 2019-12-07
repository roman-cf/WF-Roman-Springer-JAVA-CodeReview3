package citybike;
import java.time.LocalDateTime;

public class Rent {
    private int rentID;
    private static int idCount = 1;
    private int bikeID;
    private LocalDateTime RentStart;
    private LocalDateTime RentEnd;

    public Rent(int bikeID,int userID) {
        this.rentID = idCount++;
        this.bikeID=bikeID;
        RentStart = LocalDateTime.now();
        RentEnd = null;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        RentEnd = rentEnd;
    }
}
