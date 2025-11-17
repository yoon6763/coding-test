package programmers.lv0.가장_큰_수_찾기

fun solution(array: IntArray): IntArray {
    val max = array.maxOrNull()!!
    return intArrayOf(max, array.indexOf(max))
}