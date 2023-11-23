package programmers.lv1;

public class 시저_암호 {
    public String solution(String s, int n) {
        String answer = "";

        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == ' ')
                answer = answer + " ";
            else
            {
                if(s.charAt(i) < 'a' && s.charAt(i) + n > 'Z')
                    answer = answer + (char)(s.charAt(i)+n+'A'-'Z'-1);
                else if(s.charAt(i) + n > 'z')
                    answer = answer + (char)(s.charAt(i)+n+'a'-'z'-1);
                else
                    answer = answer + (char)(s.charAt(i)+n);
            }
        }
        return answer;
    }
}
