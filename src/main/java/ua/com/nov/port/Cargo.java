package ua.com.nov.port;

public class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }

    @Override
    public float calculatePayment() {
        return DEFAULT_RENTAL*tonnage;
    }

    public float calculatePayment(float rental) {
        if (rental > 0) {
            return tonnage*rental;
        } else {
            return calculatePayment();
        }
    }
}