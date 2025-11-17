package programmers.lv3.코딩_테스트_공부;

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = 0;
        int targetCop = 0;

        for(int i = 0; i < problems.length; i++) {
            targetAlp = Math.max(targetAlp, problems[i][0]);
            targetCop = Math.max(targetCop, problems[i][1]);
        }

        if(alp >= targetAlp && cop >= targetCop) return 0;

        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        int[][] dp = new int[targetAlp + 2][targetCop + 2];

        for(int i = alp; i <= targetAlp; i++) {
            for(int j = cop; j <= targetCop; j++) {
                dp[i][j] = 987654321;
            }
        }

        dp[alp][cop] = 0;

        for(int i = alp; i <= targetAlp; i++) {
            for(int j = cop; j <= targetCop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);

                for(int k = 0; k < problems.length; k++) {
                    if(i >= problems[k][0] && j >= problems[k][1]) {
                        int nAlp = Math.min(i + problems[k][2], targetAlp);
                        int nCop = Math.min(j + problems[k][3], targetCop);
                        dp[nAlp][nCop] = Math.min(dp[nAlp][nCop], dp[i][j] + problems[k][4]);
                    }
                }
            }
        }
        return dp[targetAlp][targetCop];
    }
}