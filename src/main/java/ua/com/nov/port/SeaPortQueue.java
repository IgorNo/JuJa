package ua.com.nov.port;

import java.util.Arrays;
import java.util.Comparator;

interface SeaPortQueue {
    public final static int LENGTH_QUEUE_SHIP = 3;
    public int addShipToEndQueue(AbstractShip ship);
    public int removeShipFromBeginQueue();
    public String printQueueShip();
}

class OdessaSeaPort implements SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    private int indexShipInPort = NO_SHIP_IN_ARRAY;
    private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];

    @Override
    public int addShipToEndQueue(AbstractShip ship) {
        if (indexShipInPort >= LENGTH_QUEUE_SHIP - 1) {
            return NO_SHIP_IN_ARRAY;
        } else {
            arrayShip[++indexShipInPort] = ship;
            return indexShipInPort;
        }
    }

    @Override
    public int removeShipFromBeginQueue() {
        if (indexShipInPort > 0) {
            System.arraycopy(arrayShip, 1, arrayShip, 0, indexShipInPort--);
            return 1;
        } else {
            return NO_SHIP_IN_ARRAY;
        }
    }

    @Override
    public String printQueueShip() {
        String result = "";
        if (indexShipInPort >= 0) {

            for (int i = 0; i <= indexShipInPort ; i++) {
                result += "{";
                result += arrayShip[i].toPrint() + "};";
            }
        } else {
            result = "QueueEmpty";
        }
        return result;
    }

    public static String sortSumPaymentAsc(AbstractShip[] arrayShips) {
        String result = "";
        if (arrayShips != null) {
            Arrays.sort(arrayShips, new Comparator<AbstractShip>() {
                @Override
                public int compare(AbstractShip o1, AbstractShip o2) {
                    return (int) (o1.calculatePayment() - o2.calculatePayment());
                }
            });
            for (AbstractShip ship : arrayShips) {
                result += ship.getName() + "=" + ship.calculatePayment();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String testLinerName = "TestLinerName";
        float testLinerLength = 1000;
        float testLinerWidth = 1000;
        float testLinerDisplacement = 1000;
        int testLinerPassengers = 100;
        String testCargoName = "TestCargoName";
        float testCargoLength = 1000;
        float testCargoWidth = 1000;
        float testCargoDisplacement = 1000;
        float testCargoTonnage = 100;
        String testTankerName = "TestTankerName";
        float testTankerLength = 1000;
        float testTankerWidth = 1000;
        float testTankerDisplacement = 1000;
        float testTankerVolume = 100;

        String expectedSortedShipString = "TestTankerName=25000.0TestCargoName=55000.0TestLinerName=100000.0";

        // check arrays length > 0
        AbstractShip[] arrayShips = {
                new Liner(testLinerName, testLinerLength, testLinerWidth, testLinerDisplacement, testLinerPassengers),
                new Cargo(testCargoName, testCargoLength, testCargoWidth, testCargoDisplacement, testCargoTonnage),
                new Tanker(testTankerName, testTankerLength, testTankerWidth, testTankerDisplacement, testTankerVolume)
        };

        String actualSortedShipString = OdessaSeaPort.sortSumPaymentAsc(arrayShips);

        if (!(actualSortedShipString.equals(expectedSortedShipString)))
            throw new AssertionError("Expected to be printed " + expectedSortedShipString + " but found " + actualSortedShipString);

        System.out.print("OK");
    }

}


 