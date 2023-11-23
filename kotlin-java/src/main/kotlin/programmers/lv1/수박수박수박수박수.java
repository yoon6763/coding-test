package programmers.lv1;

public class 수박수박수박수박수 {
    public String solution(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                s = s + "수";
            else
                s = s + "박";
        }
        return s;
    }
}
