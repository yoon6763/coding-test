using System;

public class Solution {
    public string solution(int age) {
        string strAge = age.ToString();
        string answer = "";
        string[] str = new string[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        for (int i = 0; i < strAge.Length; i++) {
            answer += str[int.Parse(strAge[i].ToString())];
        }
     
        return answer;
    }
}