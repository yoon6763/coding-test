package programmers.lv1;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        String answer = "";
        int count = 0;

        for(int i = 0; i<s.length(); i++)
        {
            String temp = s.charAt(i)+"";

            if(temp.equals(" "))
            {
                count = 0;
                answer = answer + ' ';
            }
            else
            {
                if(count%2 == 1)
                    answer = answer + temp.toLowerCase();
                else
                    answer = answer + temp.toUpperCase();
                count++;
            }
        }

        return answer;
    }
}
