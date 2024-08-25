package com.dncoyote.DSA.blind75.sliding_window;

public class BuyAndSellCryptoOptimal {
    public static void main(String[] args) {
        int[] crypto = { 10, 1, 5, 6, 7, 1 };
        int profit = buyAndSellCrypto(crypto);
        System.out.println(profit);
    }

    private static int buyAndSellCrypto(int[] crypto) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;
        while (right < crypto.length) {
            if (crypto[left] < crypto[right]) {
                maxProfit = Math.max(maxProfit, crypto[right] - crypto[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
