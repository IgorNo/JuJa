package ua.com.nov.port;

public class Liner extends AbstractShip {

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Liner(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
    }

    @Override
    public float calculatePayment() {
        return passengers*DEFAULT_RENTAL;
    }

    public float calculatePayment(float rental) {
        if (rental > 0) {
            return passengers*rental;
        } else {
            return calculatePayment();
        }
    }
}

 