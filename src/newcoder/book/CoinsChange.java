package newcoder.book;

public class CoinsChange {
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0)
            return 0;
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int i, int rest) {
        if (i == arr.length)
            return rest == 0 ? 1 : 0;
        int sum = 0;
        for (int k = 0; k * arr[i] <= rest; k++) {
            sum += process(arr, i + 1, rest - k * arr[i]);
        }
        return sum;
    }

    public static int coins2(int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i * arr[0] <= aim; i++)
            dp[0][i * arr[0]] = 1;
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i])
                    dp[i][j] += dp[i][j - arr[i]];
            }
        }
        return dp[n - 1][aim];
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int i = coins1(arr, 15);
        System.out.println(i);
        System.out.println(coins2(arr, 15));
    }

}
