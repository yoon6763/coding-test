package programmers.lv1;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String s = Long.toString(n);
        String[] arr = s.split("");
        int answer[] = new int[arr.length];

        for (int i = 0; i < answer.length; i++)
            answer[answer.length - i - 1] = Integer.parseInt(arr[i]);
        return answer;
    }
}
