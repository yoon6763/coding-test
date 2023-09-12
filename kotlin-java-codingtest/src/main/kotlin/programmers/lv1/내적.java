package programmers.lv1;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int result = 0;
        for(int i = 0; i <a.length; i++)
            result = a[i]*b[i] + result;
        return result;
    }
}
