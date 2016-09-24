package ua.com.nov.port;

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

    public static void main(String[] args) {
///check successful remove ship
        String testLinerName = "NameTestLiner";
        float testLinerLength = 1000;
        float testLinerWidth = 1000;
        float testLinerDisplacement = 1000;
        int testLinerPassengers = 100;
        String testCargoName = "NameTestCargo";
        float testCargoLength = 1000;
        float testCargoWidth = 1000;
        float testCargoDisplacement = 1000;
        float testCargoTonnage = 100;
        String testTankerName = "NameTestTanker";
        float testTankerLength = 1000;
        float testTankerWidth = 1000;
        float testTankerDisplacement = 1000;
        float testTankerVolume = 100;

        String expectedResultPrintShipQueueAfterRemove = "{Name=NameTestLinerLength=1000.0Width=1000.0Displacement=1000.0};{Name=NameTestTankerLength=1000.0Width=1000.0Displacement=1000.0};";

        int expectedSuccessfulStatusRemoveShipInQueue = 1;

        AbstractShip testLiner = new Liner(testLinerName, testLinerLength, testLinerWidth, testLinerDisplacement, testLinerPassengers);
        AbstractShip testCargo = new Cargo(testCargoName, testCargoLength, testCargoWidth, testCargoDisplacement, testCargoTonnage);
        AbstractShip testTanker = new Tanker(testTankerName, testTankerLength, testTankerWidth, testTankerDisplacement, testTankerVolume);

        OdessaSeaPort odessaSeaPort = new OdessaSeaPort();


        odessaSeaPort.addShipToEndQueue(testCargo);
        odessaSeaPort.addShipToEndQueue(testLiner);
        odessaSeaPort.addShipToEndQueue(testTanker);


        int actualSuccessfulStatusRemoveShipInQueue = odessaSeaPort.removeShipFromBeginQueue();
        if (actualSuccessfulStatusRemoveShipInQueue != expectedSuccessfulStatusRemoveShipInQueue)
            throw new AssertionError("Successful status remove ship in queue 1 but found " + actualSuccessfulStatusRemoveShipInQueue);

        String actualPrintShipQueueAfterRemove = odessaSeaPort.printQueueShip();
        if(!(actualPrintShipQueueAfterRemove.equals(expectedResultPrintShipQueueAfterRemove)))
            throw new AssertionError("Expected to be printed " + expectedResultPrintShipQueueAfterRemove + " but found " + actualPrintShipQueueAfterRemove);


        System.out.print("OK");
    }

}
 