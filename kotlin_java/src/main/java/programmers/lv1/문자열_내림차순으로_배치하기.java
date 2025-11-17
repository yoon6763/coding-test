package programmers.lv1;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        char ch2[] = new char[ch.length];
        for(int i = 0; i<ch.length;i++)
            ch2[ch.length-i-1] = ch[i];
        String answer = new String(ch2);
        return answer;
    }
}
