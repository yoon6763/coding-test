package programmers.lv1;

public class 하샤드_수 {
    public boolean solution(int x) {
        int initx = x;
        int sum = 0;
        while(x>0)
        {
            sum = sum + x%10;
            x = x/10;
        }
        if(initx%sum == 0)
            return true;
        else
            return false;
    }
}
