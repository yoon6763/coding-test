package programmers.lv2.양궁대회;


public class 양궁대회 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

}

class Solution {
    int maxScore = -1;
    int[] ansArrow = new int[11];
    int[] ryanArrow = new int[11];
    int[] apeachArrow = new int[11];

    int[] solution(int n, int[] info) {
        apeachArrow = info;

        backTracking(0, n);

        if (maxScore == -1) {
            return new int[]{-1};
        }
        return ansArrow;
    }

    void backTracking(int index, int restArrow) {
        if (restArrow == 0) {
            gameEnd();
            return;
        }

        if (index == 11) {
            return;
        }

        for (int i = 0; i <= apeachArrow[index] + 1; i++) {
            ryanArrow[index] = i;
            backTracking(index + 1, restArrow - i);
            ryanArrow[index] = 0;
        }
    }

    void gameEnd() {
        int rScore = 0;
        int aScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryanArrow[i] == 0 && apeachArrow[i] == 0) continue;

            if (ryanArrow[i] > apeachArrow[i]) {
                rScore += (10 - i);
            } else {
                aScore += (10 - i);
            }
        }

        if (rScore > aScore) {
            int diff = rScore - aScore;

            if (diff > maxScore) {
                maxScore = diff;
                ansArrow = ryanArrow.clone();
                return;
            }

            if (diff == maxScore) {
                for (int i = 0; i < 11; i++) {
                    if (ryanArrow[10 - i] == ansArrow[10 - i]) continue;
                    if (ryanArrow[10 - i] > ansArrow[10 - i]) {
                        ansArrow = ryanArrow.clone();
                    }
                    break;
                }
            }
        }
    }
}