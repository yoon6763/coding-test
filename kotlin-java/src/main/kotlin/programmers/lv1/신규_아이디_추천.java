package programmers.lv1;

import java.util.StringTokenizer;

public class 신규_아이디_추천 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringTokenizer st = new StringTokenizer(new_id,"#~!@#$%^&*()=+[{]}:?,<>/");

        String str = "";

        while(st.hasMoreTokens())
            str = str + st.nextToken();

        while(str.indexOf("..") != -1)
            str = str.replace("..", ".");

        if(!str.isEmpty())
        {
            if(str.charAt(0) == '.')
                str = str.substring(1,str.length());
            if(str.length() >= 1)
                if(str.charAt(str.length()-1) == '.')
                    str = str.substring(0,str.length()-1);
        }
        if(str.isEmpty())
            str = "a";

        if(str.length()>=16)
        {
            str = str.substring(0,15);
            if(str.charAt(str.length()-1) == '.')
                str = str.substring(0,str.length()-1);
        }

        if(str.length()<=2)
        {
            while(str.length() < 3)
            {
                if(str.length() >= 1)
                    str = str + str.charAt(str.length()-1);
                else
                    str = str + str;

            }
        }

        return str;
    }
}
