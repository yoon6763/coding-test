package programmers.lv1;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {

        int[] arr2 = new int[arr.length];
        int p = 0;
        arr2[0] = arr[0];

        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] != arr2[p])
            {
                arr2[p+1] = arr[i];
                p++;
            }
        }

        int[] arr3 = new int[p+1];

        for(int i = 0; i<=p; i++)
        {
            arr3[i] = arr2[i];
        }

        return arr3;
    }
}
