package programmers.lv2;

public class 숫자의_표현 {
    public int solution(int n) {
        int[] arr = new int[n+1];

        for(int i = 1; i<=n; i++) {
            arr[i] = i;
        }

        int left = 1;
        int right = 1;

        int sum = 1;

        int cnt = 0;

        while(left <= right && right <= n) {
            if(sum < n) {
                sum += (++right);
            } else if(sum > n) {
                sum -= left++;
            } else {
                cnt++;
                sum -= left++;
            }
        }


        return cnt;
    }
}
