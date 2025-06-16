package slidingwindow;

public class BuyAndSellCrypto {
  public static void main(String[] args) {
    int[] crypto = { 10, 1, 5, 6, 7, 1 };
    int profit = buyAndSellCryptoOptimal(crypto);
    System.out.println(profit);
  }

  private static int buyAndSellCryptoOptimal(int[] crypto) {
    int maxProfit = 0;
    int left = 0;
    int right = left + 1;
    while (right < crypto.length) {
      if (crypto[left] < crypto[right]) {
        int profit = crypto[right] - crypto[left];
        maxProfit = Math.max(maxProfit, profit);
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }

  private static int buyAndSellCryptoBrute(int[] crypto) {
    int maxProfit = 0;
    for (int i = 0; i < crypto.length; i++) {
      for (int j = i + 1; j < crypto.length; j++) {
        int profit = crypto[j] - crypto[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }
    return maxProfit;
  }

}
