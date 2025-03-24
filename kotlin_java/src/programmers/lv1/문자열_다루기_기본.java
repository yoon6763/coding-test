package programmers.lv1;

public class 문자열_다루기_기본 {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6)
        {
            int count = 0;
            for(int i = 0; i<s.length(); i++)
                if((int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48)
                    count++;
            if(count == s.length())
                return true;
        }
        return false;
    }
}
