package programmers.lv3.정수_삼각형;

import static java.lang.Math.max;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        if(n == 1) return triangle[0][0];

        int dp[][] = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        for(int i = 1; i<n - 1; i++) {
            for(int j = 0; j<=i; j++) {
                dp[i+1][j] = max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }


        int max = 0;
        for(int i = 0; i < n; i++) {
            max = max(max, dp[n-1][i]);
        }

        return max;
    }
}
