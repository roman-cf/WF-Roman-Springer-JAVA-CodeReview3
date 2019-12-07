package citybike;
import java.time.LocalDateTime;

public class Rent {
    private int bikeID;
    private LocalDateTime RentStart;
    private LocalDateTime RentEnd;

    public Rent(int bikeID) {
        this.bikeID=bikeID;
        RentStart = LocalDateTime.now();
        RentEnd = null;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        RentEnd = rentEnd;
    }
}
