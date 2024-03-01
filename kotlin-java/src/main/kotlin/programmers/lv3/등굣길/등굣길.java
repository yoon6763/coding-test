package programmers.lv3.등굣길;

import java.util.Arrays;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        Arrays.stream(puddles).forEach(ints -> dp[ints[1]-1][ints[0]-1] = -1);
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) continue;
                if (j > 0 && dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
                if (i > 0 && dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 1000000007;
            }
        }

        return dp[n - 1][m - 1];
    }
}
