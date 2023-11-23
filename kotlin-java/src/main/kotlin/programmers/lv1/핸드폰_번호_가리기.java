package programmers.lv1;

public class 핸드폰_번호_가리기 {
    public String solution(String phone_number) {
        String s = "";
        for(int i =0;i<phone_number.length()-4;i++)
            s = s + "*";
        s = s + phone_number.substring(phone_number.length()-4,phone_number.length());
        return s;
    }
}
