package programmers.lv1;

public class 삼총사 {
    public static void main(String[] args) {

    }

    public int solution(int[] number) {
        int n = number.length;
        int cnt = 0;

        for(int i = 0; i<n; i++) {
            for(int j = i + 1; j<n; j++) {
                for(int k = j+1; k<n; k++) {
                    if(number[i] + number[j] + number[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}
