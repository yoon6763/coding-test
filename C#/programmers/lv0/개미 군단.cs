using System;

public class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] attack = new int[] {5,3,1};

        for (int i = 0; i < attack.Length; i++) {
            if (hp >= attack[i]) {
                answer += hp / attack[i];
                hp %= attack[i];
            }
        }

        return answer;
    }
}