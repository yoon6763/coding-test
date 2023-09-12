package programmers.lv1;

public class 콜라츠_추측 {
    public int solution(int num) {
        long lnum = num;
        int count = 0;
        if(num == 1)
            return 0;
        for(int i = 0; i<500; i++)
        {
            if(lnum%2 == 0)
                lnum = lnum/2;
            else
                lnum = lnum * 3 + 1;

            count++;
            if(lnum == 1)
                return count;
        }
        return -1;
    }
}
