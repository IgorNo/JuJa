package ua.com.nov.lab39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryWithResource {
public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
    AutoCloseable a = null;
    AutoCloseable b = null;
    try {
        a = factoryA.create();
        b = factoryB.create();
        body.runBody();
    } catch (Throwable bodyEx) {
        if (b != null) {
            try {
                b.close();
            } catch (Throwable closeEx) {
                bodyEx.addSuppressed(closeEx);
            }
        }
        if (a != null) {
            try {
                a.close();
            } catch (Throwable closeEx) {
                bodyEx.addSuppressed(closeEx);
            }
        }
        throw bodyEx;
    }

    try {
        b.close();
    } catch (Throwable closeBEx) {
        try {
            a.close();
        } catch (Throwable closeAEx) {
            closeBEx.addSuppressed(closeAEx);
        }
        throw closeBEx;
    }
    a.close();
}
}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}

interface TryBody {
    public void runBody() throws Throwable;
}

class Test {
    public static void main(String[] args) {
        //prepare
        final List<String> actualHistoryCall = new ArrayList<String>();
        final List<String> expectedExceptionTextAndOrder = new ArrayList<String>();
        expectedExceptionTextAndOrder.add("Error closeA");
        List<String> expectedHistoryCall = Arrays.asList("factoryA.createA", "factoryB.createB", "TryBody.runBody", "B.close", "A.close");

        final AutoCloseable resourceA = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                actualHistoryCall.add("A.close");
                throw new Error(expectedExceptionTextAndOrder.get(0));
            }
        };

        final AutoCloseable resourceB = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                actualHistoryCall.add("B.close");

            }
        };

        AutoCloseableFactory factoryA = new AutoCloseableFactory() {
            @Override
            public AutoCloseable create() throws Throwable {
                actualHistoryCall.add("factoryA.createA");
                return resourceA;

            }


        };

        AutoCloseableFactory factoryB = new AutoCloseableFactory() {
            @Override
            public AutoCloseable create() {
                actualHistoryCall.add("factoryB.createB");
                return resourceB;
            }


        };

        TryBody tryBody = new TryBody() {
            @Override
            public void runBody() {
                actualHistoryCall.add("TryBody.runBody");
                //Nop
            }
        };

        //call and  check
        try {
            TryWithResource.twoResource(factoryA, factoryB, tryBody);
        } catch (Throwable e) {

            if (!expectedExceptionTextAndOrder.get(0).equals(e.getMessage()))
                throw new AssertionError("Not correct main exception");

            if (e.getSuppressed().length != 0)
                throw new AssertionError("Should not be suppressed exceptions  " + e.getSuppressed().length);
        }


        if (!actualHistoryCall.equals(expectedHistoryCall))
            throw new AssertionError("Not correct order call should be " + expectedHistoryCall.toString() + " but found " + actualHistoryCall.toString());

        System.out.print("OK");
    }
}
