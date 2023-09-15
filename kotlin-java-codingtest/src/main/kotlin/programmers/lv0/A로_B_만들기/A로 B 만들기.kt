package programmers.lv0.A로_B_만들기

fun solution(before: String, after: String): Int {
    return if (before.toCharArray().sorted().toString() == after.toCharArray().sorted().toString()) 1 else 0
}