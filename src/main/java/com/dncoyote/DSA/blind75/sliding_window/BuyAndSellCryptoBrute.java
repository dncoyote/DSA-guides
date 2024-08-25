package com.dncoyote.DSA.blind75.sliding_window;

public class BuyAndSellCryptoBrute {
    public static void main(String[] args) {
        int[] crypto = { 10, 1, 5, 6, 7, 1 };
        // int[] profit = buyAndSellCrypto(crypto);
        int profit = buyAndSellCrypto(crypto);
        System.out.println(profit);
        // for (int n : profit)
        // System.out.println(n);
    }

    private static int buyAndSellCrypto(int[] crypto) {
        int maxProfit = 0;
        for (int i = 0; i < crypto.length; i++) {
            for (int j = i + 1; j < crypto.length; j++) {
                int profit = crypto[j] - crypto[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // private static int[] buyAndSellCrypto(int[] crypto) {
    // int[] maxProfit = new int[crypto.length];
    // for (int i = 0; i < crypto.length; i++) {
    // int maxProfitVal = 0;
    // for (int j = i + 1; j < crypto.length; j++) {
    // int profit = crypto[j] - crypto[i];
    // maxProfitVal = Math.max(maxProfitVal, profit);
    // }
    // maxProfit[i] = maxProfitVal;
    // }
    // return maxProfit;
    // }
}
