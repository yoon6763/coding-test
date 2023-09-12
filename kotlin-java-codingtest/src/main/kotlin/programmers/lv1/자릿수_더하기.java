package programmers.lv1;

public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;

        while(n > 0)
        {
            answer = answer + n%10;
            n = n/10;
        }
        return answer;
    }
}
