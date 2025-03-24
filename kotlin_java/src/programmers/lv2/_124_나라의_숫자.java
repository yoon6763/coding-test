package programmers.lv2;

public class _124_나라의_숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 3;
            n /= 3;
            if (r == 0) {
                n--;
                r = 4;
            }
            sb.append(r);
        }
        return sb.reverse().toString();
    }
}
