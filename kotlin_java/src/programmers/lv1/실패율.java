package programmers.lv1;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] sum = new int[N+1];
        double[] clear = new double[N+1];
        int num[] = new int[N+1];

        for(int i = 0; i<stages.length; i++)
            sum[stages[i]-1]++;

        for(int i = 0; i<N; i++)
        {
            num[i] = i+1;
            int temp = 0;
            for(int j = i; j<=N; j++)
                temp = temp + sum[j];
            clear[i] = (double)sum[i]/temp;
        }

        for (int i = clear.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
            {
                if (clear[j] < clear[j + 1])
                {
                    double tmp = clear[j];
                    clear[j] = clear[j + 1];
                    clear[j + 1] = tmp;
                    int tmp2 = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp2;
                }
            }

        int[] result = new int[N];
        for(int i = 0; i<N; i++)
        {
            result[i] = num[i];
        }
        return result;
    }
}
