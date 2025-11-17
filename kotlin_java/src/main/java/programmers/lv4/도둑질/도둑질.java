package programmers.lv4.도둑질;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        for(int i = 0; i < n; i++) {
            dp1[i + 1] = money[i];
            dp2[i + 1] = money[i];
        }

        dp2[1] = 0;

        for(int i = 2; i <= n; i++) {
            dp1[i] = Math.max(dp1[i], Math.max(dp1[i-2] + money[i - 1], dp1[i-1]));
            dp2[i] = Math.max(dp2[i], Math.max(dp2[i-2] + money[i - 1], dp2[i-1]));
        }

        return Math.max(dp1[n-1], dp2[n]);
    }
}