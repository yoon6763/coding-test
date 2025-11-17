package programmers.lv1;

import java.util.Arrays;
import java.util.LinkedList;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        LinkedList<Long> lnk = new LinkedList<Long>();

        while(n > 0)
        {
            lnk.add(n%10);
            n = n/10;
        }

        for(int i = 0; i<lnk.size(); i++)
        {
            System.out.println(lnk.get(i));
        }

        long[] nums = new long[lnk.size()];

        for(int i = 0; i<nums.length; i++)
        {
            nums[i] = lnk.get(i);
        }

        Arrays.sort(nums);
        long result = 0;
        int p = 1;
        for(int i = 0; i<nums.length; i++)
        {
            result = result + (long)Math.pow(10,(i+1)) * nums[i];
        }
        result = result/10;
        return result;
    }
}
