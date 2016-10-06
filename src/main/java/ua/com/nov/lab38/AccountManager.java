package ua.com.nov.lab38;

public class AccountManager {
    public static boolean transfer(Account[] accounts, int[] delta) {
        for (int i = 0; i < accounts.length; i++) {
            try {
                accounts[i].change(delta[i]);
            } catch (TryAgainException tae) {
                i--;
            } catch (BlockAccountException bae) {
                Account[] accountsTemp = new Account[i];
                int[] deltaTemp = new int[i];
                for (int j = 0; j < accountsTemp.length; j++) {
                    accountsTemp[j] = accounts[j];
                    deltaTemp[j] = -delta[j];
                }
                transfer(accountsTemp, deltaTemp);
                return false;
            }
        }
        return true;
    }
}

abstract class Account {
    protected int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public abstract void change(int delta) throws TryAgainException, BlockAccountException;

    public int getAmount() {
        return amount;
    }
}


class TryAgainException extends Exception {
}

class BlockAccountException extends Exception {
}

class Test {
    public static void main(String[] args) {
        Account[] testAccounts = new Account[3];
        int[] testDelta = {100, 343, 245};

        int accountSum0 = 10;
        int accountSum1 = 25;
        int accountSum2 = 64;

        Account noExceptionAccount0 = new Account(accountSum0) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                this.amount = amount + delta;
            }
        };


        Account noExceptionAccount1 = new Account(accountSum1) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                amount = amount + delta;
            }
        };


        Account blockExceptionAccount = new Account(accountSum2) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                throw new BlockAccountException();
            }
        };
        testAccounts[0] = noExceptionAccount0;
        testAccounts[1] = noExceptionAccount1;
        testAccounts[2] = blockExceptionAccount;

        // call
        boolean actualResultTransfer = AccountManager.transfer(testAccounts, testDelta);

        //check
        if (actualResultTransfer)
            throw new AssertionError("should to be result transfer is false but found true");

        if (testAccounts[0].getAmount() != accountSum0)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum0 + " but found " + testAccounts[0].getAmount());

        if (testAccounts[1].getAmount() != accountSum1)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum1 + " but found " + testAccounts[1].getAmount());

        if (testAccounts[2].getAmount() != accountSum2)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum2 + " but found " + testAccounts[2].getAmount());

        System.out.print("OK");

    }
}
