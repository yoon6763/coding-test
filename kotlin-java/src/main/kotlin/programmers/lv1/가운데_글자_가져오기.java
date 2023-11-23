package programmers.lv1;

public class 가운데_글자_가져오기 {
    public String solution(String s) {

        String result = "";

        if(s.length()%2 == 0)
            result = s.substring(s.length()/2-1,s.length()/2+1);
        else
            result = s.substring(s.length()/2,s.length()/2+1);

        return result;
    }
}
