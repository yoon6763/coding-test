package programmers.lv2.땅따먹기;

import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;

        int[][] dp = new int[n][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + land[i + 1][k]);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        return answer;
    }
}