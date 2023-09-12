package programmers.lv1;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int person[][] = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};

        int[] count = {0,0,0};

        for(int i = 0; i<answers.length; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(person[j][i%person[j].length] == answers[i])
                    count[j]++;
            }
        }
        int max = count[0];
        for(int i = 1; i<3; i++)
            if(max < count[i])
                max = count[i];

        int resultcount = 0;
        for(int i = 0; i<3; i++)
            if(max == count[i])
                resultcount++;

        int p = 0;
        int result[] = new int[resultcount];

        for(int i = 0; i<3; i++)
        {
            if(max == count[i])
            {
                result[p] = i+1;
                p++;
            }
        }
        return result;
    }
}
