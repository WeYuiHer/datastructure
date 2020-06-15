package leetcode.question;


import java.util.Arrays;
import java.util.Comparator;


public class Question354 {
    class Envelope {
        int weight;
        int height;

        public Envelope(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        int n = envelopes.length;
        if (n == 1)
            return 1;
        Envelope[] envs = new Envelope[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            Envelope envelope = new Envelope(envelopes[i][0], envelopes[i][1]);

            envs[i] = envelope;
        }
        Arrays.sort(envs, new Comparator<Envelope>() {
            @Override
            public int compare(Envelope o1, Envelope o2) {
                if (o1.weight == o2.weight) {
                    return o2.height - o1.height;
                } else
                    return o1.weight - o2.weight;
            }
        });

        for (int i = 0; i < n; i++) {
            heights[i] = envs[i].height;
        }
        return getdp(heights);
    }

    public int getdp(int[] heights) {
        int n = heights.length;
        int[] ends = new int[n];
        int[] dp = new int[n];
        ends[0] = heights[0];
        dp[0] = 1;
        int l = 0, r = 0, right = 0;
        int max = 1;
        for (int i = 1; i < n; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (ends[mid] < heights[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ends[l] = heights[i];
            dp[i] = l + 1;
            max = Math.max(max, dp[i]);
            right = Math.max(l, right);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Question354 q = new Question354();
        int i = q.maxEnvelopes(envelopes);
        System.out.println(i);
    }

}
