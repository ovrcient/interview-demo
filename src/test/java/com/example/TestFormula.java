package com.example;

public class TestFormula {
    public static void main(String[] args) {
        new TestFormula().testGetRewardsByTransaction();
    }

    public void testGetRewardsByTransaction() {
        System.out.println("test");
        int k = 1000;
        for (int i = 0, j = 10; i < k; i += j / 2, j *= 1.5) {
            log(i, getRewardsByTransaction(i));
        }
        log(50, getRewardsByTransaction(50));
        log(51, getRewardsByTransaction(51));
        log(120, getRewardsByTransaction(120));
    }

    public int getRewardsByTransaction(int transaction) {
        if (transaction <= 50) return 0;
        else if (transaction <= 100) return transaction - 50;
        else return ((transaction - 100) * 2) + transaction - 50;
        // else return ((transaction - 100) * 2) + 50;
    }

    public void log(int transaction, int reward) {
        System.out.printf("%5s %5s%n", transaction, reward);
    }
}
