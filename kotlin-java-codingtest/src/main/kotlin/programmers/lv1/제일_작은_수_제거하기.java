package programmers.lv1;

public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1)
        {
            int result[] = {-1};
            return result;
        }

        else
        {
            int min = arr[0];

            for(int i = 1; i<arr.length; i++)
            {
                if(min > arr[i])
                    min = arr[i];
            }

            int result[] = new int[arr.length-1];
            int p = 0;
            for(int i = 0; i<arr.length; i++)
            {
                if(min != arr[i])
                {
                    result[p] = arr[i];
                    p++;
                }
            }
            return result;
        }
    }
}
