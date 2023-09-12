package programmers.lv1;

public class _3진법_뒤집기 {
    public int solution(int n) {
        int tri = 0;
        String strtri = "";

        while(n>0)
        {
            tri = tri + n%3;
            strtri = strtri + n%3;
            tri = tri * 10;
            n = n/3;
        }

        int answer = 0;

        for(int i = 0; i<strtri.length(); i++)
        {
            int temp = (int)strtri.charAt(strtri.length()-i-1)-48;
            answer = answer + (int)Math.pow(3, i) * temp;
        }

        return answer;
    }
}
