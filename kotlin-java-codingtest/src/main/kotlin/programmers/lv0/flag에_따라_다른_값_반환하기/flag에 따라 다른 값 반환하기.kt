package programmers.lv0.flag에_따라_다른_값_반환하기

fun solution(a: Int, b: Int, flag: Boolean): Int {
    return if (flag) a + b else a - b
}