package ua.com.nov.port;

public class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        return DEFAULT_RENTAL*volume;
    }

    public float calculatePayment(float rental) {
        if (rental > 0) {
            return volume*rental;
        } else {
            return calculatePayment();
        }
    }
}