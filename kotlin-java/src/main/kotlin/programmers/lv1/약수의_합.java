package programmers.lv1;

public class 약수의_합 {
    public int solution(int n) {
        int result = 0;
        for(int i = 1; i<=n; i++)
        {
            if(n%i == 0)
                result = result + i;
        }
        return result;
    }
}
