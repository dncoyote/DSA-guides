package com.dncoyote.DSA.blind75.binary_search;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        int minEatingSpeed = kokoEatingBananasBrute(piles, h);
        System.out.println(minEatingSpeed);
    }

    private static int kokoEatingBananasBrute(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile); // Find the maximum pile size
        }

        // Brute force: Try every possible speed from 1 to maxPile
        for (int k = 1; k <= maxPile; k++) {
            if (canFinish(piles, h, k)) {
                return k; // Return the first valid speed
            }
        }

        return maxPile; // This will never be reached because a solution always exists
    }

    private static int kokoEatingBananasOptimal(int[] piles, int h) {
        int low = 1; // Min. speed by which Koko can eat
        int high = Integer.MIN_VALUE;

        // Find max. speed by which Koko can eat(biggest pile)
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canFinish(int[] piles, int h, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }
}
