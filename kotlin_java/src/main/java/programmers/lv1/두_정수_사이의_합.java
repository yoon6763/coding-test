package programmers.lv1;

public class 두_정수_사이의_합 {
    public long solution(int a, int b) {
        long answer = 0;
        int max, min;

        if(a>b)
        {
            max = a;
            min = b;
        }
        else
        {
            max = b;
            min = a;
        }

        for(int i = min; i<=max; i++)
            answer = answer + i;

        return answer;
    }
}
