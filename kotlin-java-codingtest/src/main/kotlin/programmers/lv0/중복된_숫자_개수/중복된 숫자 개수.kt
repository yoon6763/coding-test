package programmers.lv0.중복된_숫자_개수

fun solution(array: IntArray, n: Int): Int {
    return array.count{it == n}
}