package newcoder.book.dp;

//换钱的最少货币数
public class Question2 {

    public static int minCoins(int[] coins, int target) {

        return process(coins, 0, target);
    }

    public static int process(int[] coins, int j, int rest) {
        if (j == coins.length)
            return rest == 0 ? 0 : -1;
        int res = -1;
        for (int i = 0; i * coins[j] <= rest; i++) {
            int next = process(coins, j + 1, rest - i * coins[j]);
            if (next != -1)
                res = res == -1 ? next + i : Math.min(res, next + i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5, 3, 2};
        int minCoins = minCoins(coins, 19);
        System.out.println(minCoins);
    }

}
