package programmers.lv1;

public class 행렬의_덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr3 = new int[arr1.length][arr1[0].length];
        for(int i = 0; i<arr1.length; i++)
        {
            for(int j = 0; j<arr1[0].length; j++)
            {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr3;
    }
}
