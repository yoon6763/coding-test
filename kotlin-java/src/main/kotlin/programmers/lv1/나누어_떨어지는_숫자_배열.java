package programmers.lv1;

import java.util.Arrays;
import java.util.LinkedList;

public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        LinkedList<Integer> lnk = new LinkedList<Integer>();
        for(int i = 0; i<arr.length; i++)
            if(arr[i]%divisor == 0)
                lnk.add(arr[i]);

        if(lnk.size() == 0)
        {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        else
        {
            int[] result = new int[lnk.size()];
            for(int i = 0; i<result.length; i++)
            {
                result[i] = (int)lnk.get(i);
            }
            Arrays.sort(result);
            return result;
        }
    }
}
