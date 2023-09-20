using System;

public class Solution {
    public int[] solution(int[] emergency) {

        int[] emergencyScore = new int[emergency.Length];
        Array.Copy(emergency, emergencyScore, emergency.Length);
        
        Array.Sort(emergencyScore);
        Array.Reverse(emergencyScore);

        int[] answer = new int[emergency.Length];

        for (int i = 0; i < emergency.Length; i++) {
            for (int j = 0; j < emergency.Length; j++) {
                if (emergencyScore[i] == emergency[j]) {
                    answer[j] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}