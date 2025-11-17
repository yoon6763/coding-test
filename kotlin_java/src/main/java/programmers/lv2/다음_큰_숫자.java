package programmers.lv2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int bitCount = Integer.bitCount(n++);
        while (bitCount != Integer.bitCount(n)) n++;
        return n;
    }
}
