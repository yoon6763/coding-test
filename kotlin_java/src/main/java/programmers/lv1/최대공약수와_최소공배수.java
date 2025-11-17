package programmers.lv1;

public class 최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        int r=1;
        int LCM;

        int tmp1=n;
        int tmp2=m;
        if(n<m){
            n = tmp2;
            m = tmp1;
        }

        while(r>0){
            r = n % m;
            n = m;
            m = r;
        }
        LCM = tmp1* tmp2/n;

        int answer[] = new int[2];
        answer[0] = n;
        answer[1] = LCM;

        return answer;
    }
}
