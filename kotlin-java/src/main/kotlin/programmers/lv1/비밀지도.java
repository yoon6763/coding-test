package programmers.lv1;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        long[] la1 = new long[n];
        long[] la2 = new long[n];
        boolean map[][] = new boolean[n][n];

        for(int i = 0; i<n; i++)
        {
            la1[i] = Long.parseLong(Integer.toBinaryString(arr1[i]));
            la2[i] = Long.parseLong(Integer.toBinaryString(arr2[i]));
        }

        for(int i = 0; i<n; i++)
        {
            for(int j = n-1; j>=0; j--)
            {
                if(la1[i]%10 == 1)
                    map[i][j] = true;
                la1[i] = la1[i] / 10;

                if(la2[i]%10 == 1)
                    map[i][j] = true;
                la2[i] = la2[i] / 10;
            }
        }

        String answer[] = new String[n];
        for(int i = 0; i<n; i++)
        {
            answer[i] = "";
            for(int j = 0; j<n; j++)
            {
                if(map[i][j])
                    answer[i] = answer[i] + "#";
                else
                    answer[i] = answer[i] + " ";
            }
        }

        return answer;
    }
}
