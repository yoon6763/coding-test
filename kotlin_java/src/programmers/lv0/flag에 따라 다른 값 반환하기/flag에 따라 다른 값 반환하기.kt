package programmers.lv0.`flag에 따라 다른 값 반환하기`

fun solution(a: Int, b: Int, flag: Boolean): Int {
    return if (flag) a + b else a - b
}