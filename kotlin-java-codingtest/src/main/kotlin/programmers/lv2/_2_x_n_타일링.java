package programmers.lv2;

public class _2_x_n_타일링 {
    public int solution(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        return dp[n];
    }
}
