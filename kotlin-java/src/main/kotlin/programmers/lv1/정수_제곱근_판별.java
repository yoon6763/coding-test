package programmers.lv1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        double n2 = Math.sqrt(n);
        if(n2 > (int)n2)
            return -1;
        else
            return ((long)(n2+1)*((long)n2+1));
    }
}
