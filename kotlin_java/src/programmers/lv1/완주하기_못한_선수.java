package programmers.lv1;

import java.util.Arrays;

public class 완주하기_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int p = 0;

        for(int i = 0; i<participant.length; i++)
        {
            int j = 0;
            for(j = p; j<completion.length; j++)
                if(participant[i].equals(completion[j]))
                {
                    p++;
                    break;
                }
            if(j == completion.length)
            {
                answer = participant[i];
                break;
            }

        }
        return answer;
    }
}
