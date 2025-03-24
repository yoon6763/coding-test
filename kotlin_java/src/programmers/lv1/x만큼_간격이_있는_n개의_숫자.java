package programmers.lv1;

public class x만큼_간격이_있는_n개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for(int i = 1; i<n; i++)
        {
            answer[i] = answer[i-1]+x;
        }
        return answer;
    }
}
