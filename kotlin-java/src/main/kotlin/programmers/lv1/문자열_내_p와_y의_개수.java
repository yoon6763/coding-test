package programmers.lv1;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        int countp = 0, county = 0;

        for(int i = 0; i<s.length();i++)
        {
            if(s.charAt(i) == 'Y' || s.charAt(i) == 'y')
                county++;
            else if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                countp++;
        }

        return countp == county;
    }
}
