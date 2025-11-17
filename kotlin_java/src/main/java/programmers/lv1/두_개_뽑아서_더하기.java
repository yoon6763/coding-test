package programmers.lv1;

import java.util.Arrays;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {

        int[] result = new int[numbers.length*(numbers.length-1)];
        int p = 0;

        for(int i = 0; i<numbers.length; i++)
        {
            for(int j = i+1; j<numbers.length; j++)
            {
                boolean check = false;
                int sum = numbers[i] + numbers[j];

                if(p == 0)
                {
                    result[p] = sum;
                    p++;
                }
                else
                {
                    for(int k = 0; k<p; k++)
                    {
                        if(sum == result[k])
                            check = true;
                    }

                    if(check == false)
                    {
                        result[p] = sum;
                        p++;
                    }
                }
            }
        }
        int answer[] = new int[p];
        for(int i = 0; i<p; i++)
        {
            answer[i] = result[i];
        }
        Arrays.sort(answer);

        return answer;
    }
}
